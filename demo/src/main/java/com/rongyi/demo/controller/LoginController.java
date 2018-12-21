package com.rongyi.demo.controller;

import com.rongyi.demo.entity.User;
import com.rongyi.demo.exception.GlobalException;
import com.rongyi.demo.service.SignUpService;
import com.rongyi.demo.utils.Constants;
import com.rongyi.demo.utils.ResponseCode;
import com.rongyi.demo.vo.SignUpVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:xth
 * @Date:2018/12/20 15：51
 */
@Controller
public class LoginController {
    @Autowired
    SignUpService service;


    /**
     * 功能描述: 邮箱注册
     *
     * @param:
     * @return:
     * @auther: xth
     * @date: 2018/12/21 10:57
     **/
    @ResponseBody
    @RequestMapping(value = "/signUpforMail")
    public Map<String, String> signUpForMail(@Valid SignUpVo signUpVo, HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> map = new HashMap();

        signUpVo.setSignupMethod(Constants.SIGNUP_METHOD_MAIL);
        Boolean auth = service.authSign(Constants.SIGNUP_METHOD_MAIL, signUpVo);
        if (auth) {
            map.put("resultCode", ResponseCode.SUCCESS_RESPONSE_0000);
            map.put("resultMessage", "注册成功");
            return map;
        }
        return map;


    }


    /**
     * 功能描述: 手机号注册
     *
     * @param:
     * @return:
     * @auther: xth
     * @date: 2018/12/21 10:57
     **/
    @ResponseBody
    @RequestMapping(value = "/signUpforPhone")
    public Map<String, String> signUpForPhone(@Valid SignUpVo signUpVo, HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> map = new HashMap();

            signUpVo.setSignupMethod(Constants.SIGNUP_METHOD_PHONE);
            Boolean auth = service.authSign(Constants.SIGNUP_METHOD_PHONE, signUpVo);
            if (auth) {
                map.put("resultCode", ResponseCode.SUCCESS_RESPONSE_0000);
                map.put("resultMessage", "注册成功");
                return map;
            }
            return map;

    }
}
