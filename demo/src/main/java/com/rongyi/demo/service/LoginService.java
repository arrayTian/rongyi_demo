package com.rongyi.demo.service;


import com.rongyi.demo.entity.User;

import java.util.Map;

public interface LoginService {
    public Map<String,Object> getLoginByUsername(String userName,String userPassword);

    public Map<String,String> addUserInfromation(User user);
}
