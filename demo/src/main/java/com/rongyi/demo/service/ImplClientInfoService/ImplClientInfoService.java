package com.rongyi.demo.service.ImplClientInfoService;

import com.alibaba.fastjson.JSONObject;
import com.rongyi.demo.dao.mapper.ClientInfoMapper;
import com.rongyi.demo.entity.ClientInfo;
import com.rongyi.demo.entity.User;
import com.rongyi.demo.enumNotice.SysErrorEnums;
import com.rongyi.demo.noticeMessage.Message;
import com.rongyi.demo.service.clientInfoService;
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

        User user = new User();
        user.setId(2);
        HttpSession session=request.getSession();
        session.setAttribute("user",user);
        Object object  = request.getSession().getAttribute("user");
        Message message = new Message();

        /**
         * 判断是否登录 ,通过session来判断
         */
        if(object == null){
            message.setCode(SysErrorEnums.EMPTY_PARAME_USER.getErrorCode());
            message.setData(SysErrorEnums.EMPTY_PARAME_USER.getErrorMessage());
            return message;
        }
        List<ClientInfo> clientInfoList = clientInfoMapper.findClientInfoName(clientInfoName);
        int ClientInfoUserId = ((User)object).getId();
        //int ClientInfoUserId = 3;
        clientInfoList = encryptInfo(clientInfoList,ClientInfoUserId);

        message.setCode(SysErrorEnums.SUCCESSFUL.getErrorCode());
        String clientInfoListString = JSONObject.toJSONString(clientInfoList);
        message.setData(clientInfoListString);
        return message;
    }

    @Override
    public Message seachMyClient(HttpServletRequest request) {
        User user = new User();
        user.setId(2);
        HttpSession session=request.getSession();
        session.setAttribute("user",user);




        Object object  = request.getSession().getAttribute("user");
        Message message = new Message();
        /**
         * 判断是否登录 ,通过session来判断
         */
        if(object == null){
            message.setCode(SysErrorEnums.EMPTY_PARAME_USER.getErrorCode());
            message.setData(SysErrorEnums.EMPTY_PARAME_USER.getErrorMessage());
            return message;
        }
        int ClientInfoUserId = ((User)object).getId();
        //int ClientInfoUserId =3;
        List<ClientInfo> clientInfoList = clientInfoMapper.seachMyClient(ClientInfoUserId);
        message.setCode(SysErrorEnums.SUCCESSFUL.getErrorCode());
        String clientInfoListString = JSONObject.toJSONString(clientInfoList);
        message.setData(clientInfoListString);
        return message;


    }

    @Override
    public Message seachAll(HttpServletRequest request){
        User user = new User();
        user.setId(2);
        HttpSession session=request.getSession();
        session.setAttribute("user",user);



        Object object  = request.getSession().getAttribute("user");
        Message message = new Message();
        /**
         * 判断是否登录 ,通过session来判断
         */
        if(object == null){
            message.setCode(SysErrorEnums.EMPTY_PARAME_USER.getErrorCode());
            message.setData(SysErrorEnums.EMPTY_PARAME_USER.getErrorMessage());
            return message;
        }
        int ClientInfoUserId = ((User)object).getId();
        List<ClientInfo> clientInfoList = clientInfoMapper.seachAll();
        //int ClientInfoUserId = 3;
        clientInfoList = encryptInfo(clientInfoList,ClientInfoUserId);
        message.setCode(SysErrorEnums.SUCCESSFUL.getErrorCode());
        String clientInfoListString = JSONObject.toJSONString(clientInfoList);
        message.setData(clientInfoListString);
        return message;
    }

    @Override
    public Message searchLike(HttpServletRequest request,String searchName) {
        User user = new User();
        user.setId(2);
        HttpSession session=request.getSession();
        session.setAttribute("user",user);





        Object object  = request.getSession().getAttribute("user");
        Message message = new Message();
        /**
         * 判断是否登录 ,通过session来判断
         */
        if(object == null){
            message.setCode(SysErrorEnums.EMPTY_PARAME_USER.getErrorCode());
            message.setData(SysErrorEnums.EMPTY_PARAME_USER.getErrorMessage());
            return message;
        }

        List<ClientInfo> clientInfoList = clientInfoMapper.searchLike(searchName);

        int ClientInfoUserId = ((User)object).getId();
        //int ClientInfoUserId = 3;
        clientInfoList = encryptInfo(clientInfoList,ClientInfoUserId);

        message.setCode(SysErrorEnums.SUCCESSFUL.getErrorCode());
        String clientInfoListString = JSONObject.toJSONString(clientInfoList);
        message.setData(clientInfoListString);
        return message;
    }


   @Override
    public  Message findClientInfoPhone(HttpServletRequest request,String clientInfoPhone) {
       User user = new User();
       user.setId(2);
       HttpSession session=request.getSession();
       session.setAttribute("user",user);



       Object object  = request.getSession().getAttribute("user");
       Message message = new Message();
       /**
        * 判断是否登录 ,通过session来判断
        */
       if(object == null){
           message.setCode(SysErrorEnums.EMPTY_PARAME_USER.getErrorCode());
           message.setData(SysErrorEnums.EMPTY_PARAME_USER.getErrorMessage());
           return message;
       }

        List<ClientInfo> clientInfoList = clientInfoMapper.findClientInfoPhone(clientInfoPhone);
       int ClientInfoUserId = ((User)object).getId();
       //int ClientInfoUserId = 3;
       clientInfoList = encryptInfo(clientInfoList,ClientInfoUserId);

       message.setCode(SysErrorEnums.SUCCESSFUL.getErrorCode());
       String clientInfoListString = JSONObject.toJSONString(clientInfoList);
       message.setData(clientInfoListString);
       return message;

    }

    @Override
    public  Message findClientInfoEmail(HttpServletRequest request,String clientInfoEmail) {

        User user = new User();
        user.setId(2);
        HttpSession session=request.getSession();
        session.setAttribute("user",user);




        Object object  = request.getSession().getAttribute("user");
        Message message = new Message();
        /**
         * 判断是否登录 ,通过session来判断
         */
        if(object == null){
            message.setCode(SysErrorEnums.EMPTY_PARAME_USER.getErrorCode());
            message.setData(SysErrorEnums.EMPTY_PARAME_USER.getErrorMessage());
            return message;
        }


        List<ClientInfo> clientInfoList = clientInfoMapper.findClientInfoEmail(clientInfoEmail);

        int ClientInfoUserId = ((User)object).getId();
        //int ClientInfoUserId = 3;
        clientInfoList = encryptInfo(clientInfoList,ClientInfoUserId);

        message.setCode(SysErrorEnums.SUCCESSFUL.getErrorCode());
        String clientInfoListString = JSONObject.toJSONString(clientInfoList);
        message.setData(clientInfoListString);
        return message;

    }

     @Override
     public Message insertUser(HttpServletRequest request,ClientInfo clientInfo){



         String userName = clientInfo.getClientName();
         String userSex = clientInfo.getClientSex();

         Date userBirth = clientInfo.getClientBirthdayDate();
         String userGuoji = clientInfo.getClientNationality();
         String userAddress = clientInfo.getClientAddress();

         String userPhone = clientInfo.getClientPhone();
         String userEmail = clientInfo.getClientMail();

   /* public Message insertUser(HttpServletRequest request, String userName, String userSex,
                              String userBirth, String userGuoji, String userAddress
                                ,String userPhone, String userEmail) {*/
         User user = new User();
         user.setId(2);
         HttpSession session=request.getSession();
         session.setAttribute("user",user);
         Object object  = request.getSession().getAttribute("user");

         Message message = new Message();
         /**
          * 判断是否登录 ,通过session来判断
          */
         if(object == null){
             message.setCode(SysErrorEnums.EMPTY_PARAME_USER.getErrorCode());
             message.setData(SysErrorEnums.EMPTY_PARAME_USER.getErrorMessage());
             return message;
         }
            int ClientInfoUserId = ((User)object).getId();
         //int ClientInfoUserId = 2;

         //ClientInfo clientInfo = new ClientInfo();
         clientInfo.setUserId(ClientInfoUserId);
         List<ClientInfo> clientInfoList1 =   clientInfoMapper.findClientInfoEmail(userEmail);

         if(clientInfoList1.size()!=0){//判断邮箱是否被注册了
             //System.out.println("clientInfoList1    "+clientInfoList1);
             message.setCode(SysErrorEnums.EMPTY_PARAME_MAIL.getErrorCode());
             message.setData(SysErrorEnums.EMPTY_PARAME_MAIL.getErrorMessage());
             return message;
         }
         clientInfo.setClientMail(userEmail);
         clientInfo.setClientAddress(userAddress);
        // Date birthday = null;
        /* try{
             birthday = DateUtils.parseDate(userBirth,"yyyy-MM");
         }catch(ParseException e){
             message.setCode(SysErrorEnums.ERROR_PARAME_DATE.getErrorCode());
             message.setMessage(SysErrorEnums.ERROR_PARAME_DATE.getErrorMessage());
             return message;
         }*/
       /*  clientInfo.setClientBirthdayDate(birthday);
         clientInfo.setClientName(userName);
         clientInfo.setClientNationality(userGuoji);
         clientInfo.setClientPhone(userPhone);
         clientInfo.setClientSex(userSex);*/
         int res = clientInfoMapper.insertUser(clientInfo);
         System.out.println(res);
         if(res == 1){
             message.setCode(SysErrorEnums.SUCCESSFUL.getErrorCode());
             message.setData(SysErrorEnums.SUCCESSFUL.getErrorMessage());
             return message;
         }else{
             message.setCode(SysErrorEnums.FALSE.getErrorCode());
             message.setData(SysErrorEnums.FALSE.getErrorMessage());
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
