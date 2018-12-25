package com.rongyi.demo.service.SignUpServiceImpl;

import com.rongyi.demo.dao.SignUpDao;
import com.rongyi.demo.exception.GlobalException;
import com.rongyi.demo.result.CodeMsg;
import com.rongyi.demo.result.Result;
import com.rongyi.demo.service.SignUpService;
import com.rongyi.demo.utils.Constants;
import com.rongyi.demo.utils.ResponseCode;
import com.rongyi.demo.vo.SignUpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;

import java.util.Objects;

/**
 * @Author:xth
 * @Date:2018/12/21 10：11
 */
@Service
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    SignUpDao signUpDao;
    /**
     * 功能描述:
     *
     * @param:
     * @return:
     * @auther: xth
     * @date: 2018/12/21 10:13
     **/
    public Boolean authSign(String flag, SignUpVo signUpUser) {
        //查看手机号邮箱是否已经注册
        int count1 = signUpDao.queryMailorPhone(signUpUser.getUserMail());
        int count2 = signUpDao.queryMailorPhone(signUpUser.getUserPhone());
        if (count1 + count2 != Constants.SIGNUP_NUMBER_0) {
            throw new GlobalException(CodeMsg.EXIST_ERROR);
        }
        //插入数据到数据库
        Integer conunt=signUpDao.queryCount()+Constants.SIGNUP_NUMBER_1;
        signUpUser.setUserNumber(Constants.SIGNUP_USER_NUMBER+conunt);
        if (Objects.equals(flag, Constants.SIGNUP_METHOD_MAIL)) {
            int change = signUpDao.insertSignUpInfo4Mail(signUpUser);
            if (change == Constants.SIGNUP_NUMBER_1) {
                return true;
            }
        }
        if (Objects.equals(flag, Constants.SIGNUP_METHOD_PHONE)) {

            int change2 = signUpDao.insertSignUpInfo4Phone(signUpUser);
            if (change2 == Constants.SIGNUP_NUMBER_1) {
                return true;
            }
        }
        return false;
    }
}
