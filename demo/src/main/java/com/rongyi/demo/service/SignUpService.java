package com.rongyi.demo.service;

import com.rongyi.demo.vo.SignUpVo;

/**
 * @Author:xth
 * @Date:2018/12/21 10：11
 */

    public interface SignUpService {
        public Boolean authSign(String flag,SignUpVo signUpUser);
    }

