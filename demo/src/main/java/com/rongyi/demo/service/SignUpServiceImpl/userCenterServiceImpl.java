package com.rongyi.demo.service.SignUpServiceImpl;

import ch.qos.logback.core.net.server.Client;
import com.rongyi.demo.dao.userInfoDao;
import com.rongyi.demo.entity.ClientInfo;
import com.rongyi.demo.entity.User;
import com.rongyi.demo.service.UserCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:xth
 * @Date:2018/12/24 09：56
 */
@Service
public class userCenterServiceImpl implements UserCenterService {
    @Autowired
    userInfoDao userinfoDao;
    @Override
    public User getUserInfo(String userMail) {
       User userInfo =  userinfoDao.userInfo(userMail);
        System.out.println(userInfo.toString());
        return userInfo;
    }





}
