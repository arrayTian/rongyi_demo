package com.rongyi.demo.login.service;


import com.rongyi.demo.entity.User;

import java.util.Map;

public interface LoginService {
    public Map<String,Object> getLoginByUsername(String userName,String userPassword);

    public String addUserInfromation(User user);
}
