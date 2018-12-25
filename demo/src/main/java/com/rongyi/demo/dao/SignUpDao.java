package com.rongyi.demo.dao;

import com.rongyi.demo.vo.SignUpVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author:xth
 * @Date:2018/12/21 10：16
 */
@Mapper
public interface SignUpDao {
    @Select("select count(1) from demo_user_info where user_mail=#{param} or user_phone=#{param}")
    Integer queryMailorPhone(String param);

    @Insert("insert into demo_user_info(user_mail,user_password,signup_method,user_number) values(#{userMail},#{userPassword},#{signupMethod},#{userNumber})")
    Integer insertSignUpInfo4Mail(SignUpVo signUpVo);

    @Insert("insert into demo_user_info(user_phone,user_password,signup_method,user_number) values(#{userPhone},#{userPassword},#{signupMethod},#{userNumber})")
    Integer insertSignUpInfo4Phone(SignUpVo signUpVo);

    @Select("select count(1) from demo_user_info")
    Integer queryCount();
}
