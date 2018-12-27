package com.rongyi.demo.service.impl;

import com.rongyi.demo.entity.Operation;
import com.rongyi.demo.entity.User;
import com.rongyi.demo.dao.LoginMapper;
import com.rongyi.demo.service.LoginService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
@MapperScan("com.rongyi.demo.login.dao")
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    public Map<String, Object> getLoginByUsername(String userName,String userPassword){
        Map<String,Object> map = new HashMap<String,Object>();
        //0031 为第一回登陆 手机号
        //0032 为第一回登陆 邮箱
        //0033 非第一回登陆
        boolean pflag  = isPhone(userName);
        boolean mflag  = isMail(userName);
        if (pflag){
            List<User> list = loginMapper.getLoginByPhone(userName,userPassword);
            if (list.size()<1){
                map.put("responseCode","9999");
                map.put("putresultCode","5031");//手机号或密码出错
                return map;
            }else{
                List<User> methodPhone = loginMapper.getMethodAndPhone("phone",userName);
                if (methodPhone.size()<1){
                    map.put("responseCode","9999");
                    map.put("putresultCode","5036");//登陆方式错误
                    return map;
                }else{
                    Integer id = methodPhone.get(0).getId();
                    List<Operation> count = loginMapper.getPoerationByLoginTimes(id);
                    if (count.size()<1){

                        map.put("putresultCode","0031");//手机登陆成功 第一次登陆
                        map.put("id",list.get(0).getId());
                        System.out.println(list.get(0).getUserPassword());
                        map.put("userPhone",list.get(0).getUserPhone());
                    }else{
                        map.put("putresultCode","0033");//手机登陆成功 且不是第一次登陆
                        map.put("id",list.get(0).getId());
                        Integer loginTimes = count.get(0).getLoginTimes();
                        loginMapper.updateOperation(id,loginTimes+1);
                    }
                    return map;
                }

            }
        }else if (mflag){
            List<User> list = loginMapper.getLoginByMail(userName,userPassword);
            if (list.size()<1){
                map.put("responseCode","9999");
                map.put("putresultCode","5032");//邮箱号或密码出错
                return map;
            }else{
                List<User> methodMail = loginMapper.getMethodAndMail("mail",userName);
                if (methodMail.size()<1){
                    map.put("responseCode","9999");
                    map.put("putresultCode","5036");//登陆方式错误
                    return map;
                }else{
                    Integer id = methodMail.get(0).getId();
                    List<Operation> count = loginMapper.getPoerationByLoginTimes(id);
                    if (count.size()<1){
                        map.put("putresultCode","0032");//邮箱登陆成功 第一次登陆
                        map.put("id",list.get(0).getId());
                        map.put("userMail",list.get(0).getUserMail());
                    }else{
                        map.put("putresultCode","0033");//邮箱登陆成功 且不是第一次登陆
                        map.put("id",list.get(0).getId());
                        Integer loginTimes = count.get(0).getLoginTimes();
                        loginMapper.updateOperation(id,loginTimes+1);
                    }
                    return map;
                }
            }
        }else{
            List<User> list = loginMapper.getLoginByNumb(userName,userPassword);
            if (Objects.isNull(list)||list.isEmpty()){
                map.put("responseCode","9999");
                map.put("putresultCode","5033");//id号或密码出错
                return map;
            }else{
                Integer id = list.get(0).getId();
                List<Operation> count = loginMapper.getPoerationByLoginTimes(id);
                if (count.size()<1){
                    if (list.get(0).getMethod().equals("mail")){
                        map.put("putresultCode","0032");//id号登陆成功 邮箱注册 第一回登陆
                        map.put("id",list.get(0).getId());
                        map.put("userMail",list.get(0).getUserMail());
                        return map;
                    }
                    if (list.get(0).getMethod().equals("phone")){
                        map.put("putresultCode","0031");//id号登陆成功 手机号注册 第一回登陆
                        map.put("id",list.get(0).getId());
                        map.put("userPhone",list.get(0).getUserPhone());
                        return map;
                    }
                }else{
                    if (list.get(0).getMethod().equals("mail")){
                        map.put("putresultCode","0033");//id号登陆成功 邮箱注册
                        map.put("id",list.get(0).getId());
                        Integer loginTimes = count.get(0).getLoginTimes();
                        loginMapper.updateOperation(id,loginTimes+1);
                        return map;
                    }
                    if (list.get(0).getMethod().equals("phone")){
                        map.put("putresultCode","0033");//id号登陆成功 手机号注册
                        map.put("id",list.get(0).getId());
                        Integer loginTimes = count.get(0).getLoginTimes();
                        loginMapper.updateOperation(id,loginTimes+1);
                        return map;
                    }
                }

                return map;
            }
        }
    }
    //手机正则验证
    public boolean isPhone(String userName){
        String regex = "^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(userName);
        return m.matches();
    }
    //邮箱正则验证
    public boolean isMail(String userName){
        String regex = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        Pattern p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(userName);
        return m.matches();
    }

    public Map<String, String> addUserInfromation(User user){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Map<String,String> map = new HashMap<String,String>();
        Integer id = user.getId();//userid
        String userName = user.getUserName(); //用户姓名
        String userSex = user.getUserSex(); //用户性别
        String userbirthDate = user.getUserbirthDate();//用户生日
        String userNationality = user.getUserNationality(); // 用户国际
        String userAddress= user.getUserAddress(); //用户住址
        String userPhone = user.getUserPhone(); //用户电话
        String userMail = user.getUserMail(); //用户邮件
        String idCardAddress = user.getIdCardAddress(); //身份证照
        int userupdate = loginMapper.addUserInfromation(userName,userSex,userbirthDate,userNationality,userAddress,userPhone,userMail,idCardAddress,id);
       /* String userurl;
        if (userupdate>=1){
            userurl = "http://192.168.50.63/tdemo/production/fillInformation.html";
        }else{
            userurl = "http://192.168.50.63/tdemo/production/index.html";
        }*/
        loginMapper.addOperation(id,1);
        if (userupdate<1){
            map.put("putresultCode","9999");//添加失败
            map.put("resultMessage","添加失败");
        }else{
            map.put("putresultCode","0000");//添加成功
            map.put("resultMessage","添加成功");
        }
        return map;
    }
}
