package com.rongyi.demo.service.ImplClientInfoService;

import com.alibaba.fastjson.JSONObject;
import com.rongyi.demo.dao.mapper.ClientInfoMapper;
import com.rongyi.demo.entity.ClientInfo;
import com.rongyi.demo.entity.User;
import com.rongyi.demo.enumNotice.SysErrorEnums;
import com.rongyi.demo.noticeMessage.Message;
import com.rongyi.demo.service.clientInfoService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
@Service
public class ImplClientInfoService implements clientInfoService {

    @Autowired
    private ClientInfoMapper clientInfoMapper;

    @Override
    public Message findClientInfoName(HttpServletRequest request,String clientInfoName) {

        Object object  = request.getSession().getAttribute("user");
        Message message = new Message();

        /**
         * 判断是否登录 ,通过session来判断
         */
        if(object == null){
            message.setCode(SysErrorEnums.EMPTY_PARAME_USER.getErrorCode());

            return message;
        }
        List<ClientInfo> clientInfoList = clientInfoMapper.findClientInfoName(clientInfoName);
        int ClientInfoUserId = ((User)object).getId();

        clientInfoList = encryptInfo(clientInfoList,ClientInfoUserId);

        message.setCode(SysErrorEnums.SUCCESSFUL.getErrorCode());
        message.setData(clientInfoList);
        return message;
    }

    @Override
    public Message seachMyClient(HttpServletRequest request) {



        Object object  = request.getSession().getAttribute("user");
        Message message = new Message();

        /**
         * 判断是否登录 ,通过session来判断
         */
        if(object == null){
            message.setCode(SysErrorEnums.EMPTY_PARAME_USER.getErrorCode());
            return message;
        }
        int ClientInfoUserId = ((User)object).getId();
        List<ClientInfo> clientInfoList = clientInfoMapper.seachMyClient(ClientInfoUserId);
        message.setCode(SysErrorEnums.SUCCESSFUL.getErrorCode());
        message.setData(clientInfoList);
        message.setMyName(((User)object).getUserName());
        return message;


    }

    @Override
    public Message seachAll(HttpServletRequest request){

        Object object  = request.getSession().getAttribute("user");
        Message message = new Message();
        /**
         * 判断是否登录 ,通过session来判断
         */
        if(object == null){
            message.setCode(SysErrorEnums.EMPTY_PARAME_USER.getErrorCode());

            return message;
        }
        int ClientInfoUserId = ((User)object).getId();

        List<ClientInfo> clientInfoList = clientInfoMapper.seachAll();

        clientInfoList = encryptInfo(clientInfoList,ClientInfoUserId);
        message.setCode(SysErrorEnums.SUCCESSFUL.getErrorCode());
        message.setData(clientInfoList);
        return message;
    }

    @Override
    public Message searchLike(HttpServletRequest request,String searchName) {


        Object object  = request.getSession().getAttribute("user");
        Message message = new Message();
        /**
         * 判断是否登录 ,通过session来判断
         */
        if(object == null){
            message.setCode(SysErrorEnums.EMPTY_PARAME_USER.getErrorCode());
            return message;
        }

        List<ClientInfo> clientInfoList = clientInfoMapper.searchLike(searchName);

        int ClientInfoUserId = ((User)object).getId();
        clientInfoList = encryptInfo(clientInfoList,ClientInfoUserId);

        message.setCode(SysErrorEnums.SUCCESSFUL.getErrorCode());
        message.setData(clientInfoList);
        return message;
    }


   @Override
    public  Message findClientInfoPhone(HttpServletRequest request,String clientInfoPhone) {

       Object object  = request.getSession().getAttribute("user");
       Message message = new Message();
       /**
        * 判断是否登录 ,通过session来判断
        */
       if(object == null){
           message.setCode(SysErrorEnums.EMPTY_PARAME_USER.getErrorCode());
           return message;
       }

        List<ClientInfo> clientInfoList = clientInfoMapper.findClientInfoPhone(clientInfoPhone);
       int ClientInfoUserId = ((User)object).getId();
       clientInfoList = encryptInfo(clientInfoList,ClientInfoUserId);

       message.setCode(SysErrorEnums.SUCCESSFUL.getErrorCode());
       message.setData(clientInfoList);
       return message;

    }

    @Override
    public  Message findClientInfoEmail(HttpServletRequest request,String clientInfoEmail) {


        Object object  = request.getSession().getAttribute("user");
        Message message = new Message();
        /**
         * 判断是否登录 ,通过session来判断
         */
        if(object == null){
            message.setCode(SysErrorEnums.EMPTY_PARAME_USER.getErrorCode());
            return message;
        }


        List<ClientInfo> clientInfoList = clientInfoMapper.findClientInfoEmail(clientInfoEmail);

        int ClientInfoUserId = ((User)object).getId();
        clientInfoList = encryptInfo(clientInfoList,ClientInfoUserId);

        message.setCode(SysErrorEnums.SUCCESSFUL.getErrorCode());
        message.setData(clientInfoList);
        return message;

    }

     @Override
     public Message insertUser(HttpServletRequest request,ClientInfo clientInfo){
        
         String userEmail = clientInfo.getClientMail();


         Object object  = request.getSession().getAttribute("user");

         Message message = new Message();
         /**
          * 判断是否登录 ,通过session来判断
          */
         if(object == null){
             message.setCode(SysErrorEnums.EMPTY_PARAME_USER.getErrorCode());
             return message;
         }
            int ClientInfoUserId = ((User)object).getId();

         clientInfo.setUserId(ClientInfoUserId);
         List<ClientInfo> clientInfoList1 =   clientInfoMapper.findClientInfoEmail(userEmail);

         if(clientInfoList1.size()!=0){//判断邮箱是否被注册了

             message.setCode(SysErrorEnums.EMPTY_PARAME_MAIL.getErrorCode());

             return message;
         }

         int res = clientInfoMapper.insertUser(clientInfo);
         System.out.println(res);
         if(res == 1){
             message.setCode(SysErrorEnums.SUCCESSFUL.getErrorCode());
             return message;
         }else{
             message.setCode(SysErrorEnums.FALSE.getErrorCode());
             return message;
         }

     }

    public static List<ClientInfo> encryptInfo(List<ClientInfo> list,int id){
        for (int i = 0;i<list.size();i++){
            if(list.get(i).getUserId()!=id){
                StringBuffer buffer = new StringBuffer();
                String buffer1 = list.get(i).getClientPhone().substring(0,4);
                String buffer3 = list.get(i).getClientPhone().substring(7,10);
                String buffer2 = "****";
                buffer.append(buffer1);
                buffer.append(buffer2);
                buffer.append(buffer3);
                list.get(i).setClientPhone(buffer.toString());
                //
                StringBuilder builder = new StringBuilder();

                String buffer4=list.get(i).getClientMail().substring(4);
                builder.append(buffer2).append(buffer4);
                list.get(i).setClientMail(builder.toString());
            }
        }
        return list;
    }





}
