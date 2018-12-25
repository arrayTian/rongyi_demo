package com.rongyi.demo.service;

import com.rongyi.demo.entity.ClientInfo;
import com.rongyi.demo.noticeMessage.Message;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface clientInfoService {

    Message seachMyClient(HttpServletRequest request);
    Message seachAll(HttpServletRequest request);
    Message findClientInfoName(HttpServletRequest request,String clientInfoName);
    Message searchLike(HttpServletRequest request,String searchName);
    Message findClientInfoPhone(HttpServletRequest request,String clientInfoPhone);
    Message findClientInfoEmail(HttpServletRequest request,String clientInfoEmail);
   /* public Message insertUser(HttpServletRequest request, String userName, String userSex,
                              String userBirth, String userGuoji, String userAddress
                            , String userPhone, String userEmail);*/
   public Message insertUser(HttpServletRequest request,ClientInfo clientInfo);



}
