package com.rongyi.demo.dao;

import com.rongyi.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:xth
 * @Date:2018/12/24 09：57
 */
@Mapper
public interface userInfoDao {

    @Select("select user_mail as userMail,user_phone  as userPhone,user_number as userNumber,user_name as userName," +
            "user_sex as userSex,user_birth_date as userbirthDate, user_nationality as userNationality,user_address as userAdress," +
            "user_id_card_address as idCardAddress from demo_user_info where  user_phone=#{info} or user_mail=#{info} ")
    @ResultType(User.class)
    User userInfo(String info);
}
