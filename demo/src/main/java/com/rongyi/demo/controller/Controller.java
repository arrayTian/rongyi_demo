package com.rongyi.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:xth
 * @Date:2018/12/20 15：20
 */
@org.springframework.stereotype.Controller
public class Controller {


    @RequestMapping(value ="/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
