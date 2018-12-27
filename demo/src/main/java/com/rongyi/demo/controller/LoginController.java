package com.rongyi.demo.controller;

import com.rongyi.demo.entity.User;
import com.rongyi.demo.service.LoginService;
import com.rongyi.demo.utils.FileUpLoad;
import com.rongyi.demo.utils.Md5SaltTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class LoginController {

    @Autowired
    LoginService loginService;
    //登陆验证

    @RequestMapping(value = "getLogin")
    @ResponseBody
    public  Map<String,Object> getLogin(@RequestParam(value = "userName") String userName, @RequestParam(value = "userPassword") String userPassword, HttpServletRequest request) throws Exception{
        Map<String,Object> map = loginService.getLoginByUsername(userName,Md5SaltTool.md5Password("65985562365410095"+userPassword));
        System.out.println(map.get("putresultCode"));
        System.out.println(Md5SaltTool.md5Password("65985562365410095"+userPassword));
        if (map.get("putresultCode").equals("0031")||map.get("putresultCode").equals("0032")||map.get("putresultCode").equals("0033")){
            User user = new User();
            user.setId(Integer.parseInt(map.get("id").toString()));
            request.getSession().setAttribute("user",user);
        }
        return map;
    }
    @RequestMapping(value = "addUserInfromation")
    @ResponseBody
    //登陆成功后添加信息
    public Map<String,String> addUserInfromation(@RequestParam("filez") MultipartFile filez, @RequestParam("filef") MultipartFile filef, User user, HttpServletResponse response){
        String filenamez = FileUpLoad.writeUploadFile(filez,user.getUserName());
        String filenamef = FileUpLoad.writeUploadFile(filef,user.getUserName());
        user.setIdCardAddress("D:/"+user.getUserName()+filenamez+"AND"+" D:/"+user.getUserName()+filenamef);
        Map<String,String> map = loginService.addUserInfromation(user);
        return map;
    }
}
