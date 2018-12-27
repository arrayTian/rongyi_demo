package com.rongyi.demo.controller;

import com.rongyi.demo.entity.User;
import com.rongyi.demo.service.UserCenterService;
import com.rongyi.demo.utils.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:xth
 * @Date:2018/12/24 09：50
 */
@Controller
public class UserCenterController {
    @Autowired
    UserCenterService userCenterService;
     Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/getUserInfo")
    @ResponseBody
    public Map userInfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("user");
        logger.info("取到的session值为："+userName);
        User userInfo = userCenterService.getUserInfo(userName);
        Map map = new HashMap<String, String>();
        map.put("resultCode", ResponseCode.SUCCESS_RESPONSE_0000);
        map.put("param",userInfo);
        map.put("resultMessage",null);
        return map;
    }
}
