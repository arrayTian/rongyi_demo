package com.rongyi.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.rongyi.demo.entity.ClientInfo;
import com.rongyi.demo.noticeMessage.Message;
import com.rongyi.demo.service.ImplClientInfoService.ImplClientInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@RestController
@RequestMapping("/clientInfo")
public class ClientInfoController {
    @Autowired
    ImplClientInfoService implClientInfoService;

    @RequestMapping(value = "/searchAll", method = {RequestMethod.POST})
    @ResponseBody
    public Message seachAll(HttpServletRequest request) {

        return implClientInfoService.seachAll(request);
    }
    @RequestMapping(value = "/name", method = {RequestMethod.POST})
    @ResponseBody
    public Message findClientInfoName(HttpServletRequest request,String clientInfoName) {
       return  implClientInfoService.findClientInfoName(request,clientInfoName);

    }

    @RequestMapping(value = "/searchLike", method = {RequestMethod.POST})
    @ResponseBody
    public Message searchLike(HttpServletRequest request,String searchName) {
        return    implClientInfoService.searchLike(request,searchName);

    }

    @RequestMapping(value = "/findClientInfoPhone", method = {RequestMethod.POST})
    @ResponseBody
    public Message findClientInfoPhone(HttpServletRequest request,String clientInfoPhone) {
       return  implClientInfoService.findClientInfoPhone(request,clientInfoPhone);

    }
    @RequestMapping(value = "/findClientInfoEmail", method = {RequestMethod.POST})
    @ResponseBody
    public Message findClientInfoEmail(HttpServletRequest request,String clientInfoEmail) {
        return  implClientInfoService.findClientInfoEmail(request,clientInfoEmail);

    }

    @RequestMapping(value = "/insertUser", method = {RequestMethod.POST})
    @ResponseBody
    public Message insertUser(HttpServletRequest request,ClientInfo clientInfo){
       

        return implClientInfoService.insertUser(request,clientInfo);
    }

    @RequestMapping(value = "/seachMyClient", method = {RequestMethod.POST})
    @ResponseBody
    public Message seachMyClient(HttpServletRequest request){

        return implClientInfoService.seachMyClient(request);

    }



}
