package com.rongyi.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:xth
 * @Date:2018/12/24 09：57
 */
@Mapper
public interface userInfoDao {

    @Select("select * from demo_user_info where user_mail=#{info}")
    List userInfo(String info);
}
