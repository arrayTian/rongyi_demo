package com.rongyi.demo.login.dao;

import com.rongyi.demo.entity.Operation;
import com.rongyi.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LoginMapper {
    @Select("select id,\n" +
            "user_phone AS userPhone,\n" +
            "user_mail AS userMail,\n" +
            "user_number AS userNumb,\n" +
            "user_sex AS userSex,\n" +
            "user_birth_date AS userbirthDate,\n" +
            "user_nationality AS userNationality,\n" +
            "user_address AS userAddress,\n" +
            "user_id_card_address AS idCardAddress,\n" +
            "signup_method AS method,\n" +
            "user_password AS userPassword,\n" +
            "user_salt AS userSalt" +
            " from demo_user_info where user_number = #{userName} and user_password = #{userPassword}")
    @ResultType(User.class)
    public List<User> getLoginByNumb(String userName,String userPassword);

    @Select("select id,\n" +
            "user_phone AS userPhone,\n" +
            "user_mail AS userMail,\n" +
            "user_number AS userNumb,\n" +
            "user_sex AS userSex,\n" +
            "user_birth_date AS userbirthDate,\n" +
            "user_nationality AS userNationality,\n" +
            "user_address AS userAddress,\n" +
            "user_id_card_address AS idCardAddress,\n" +
            "signup_method AS method,\n" +
            "user_password AS userPassword,\n" +
            "user_salt AS userSalt" +
            " from demo_user_info where user_phone = #{userPhone} and user_password = #{userPassword}")
    @ResultType(User.class)
    public List<User> getLoginByPhone(String userPhone,String userPassword);

    @Select("select id,\n" +
            "user_phone AS userPhone,\n" +
            "user_mail AS userMail,\n" +
            "user_number AS userNumb,\n" +
            "user_sex AS userSex,\n" +
            "user_birth_date AS userbirthDate,\n" +
            "user_nationality AS userNationality,\n" +
            "user_address AS userAddress,\n" +
            "user_id_card_address AS idCardAddress,\n" +
            "signup_method AS method,\n" +
            "user_password AS userPassword,\n" +
            "user_salt AS userSalt" +
            " from demo_user_info where user_mail = #{userMail} and user_password = #{userPassword}")
    @ResultType(User.class)
    public List<User> getLoginByMail(String userMail,String userPassword);

    @Select("select id,\n" +
            "user_phone AS userPhone,\n" +
            "user_mail AS userMail,\n" +
            "user_number AS userNumb,\n" +
            "user_sex AS userSex,\n" +
            "user_birth_date AS userbirthDate,\n" +
            "user_nationality AS userNationality,\n" +
            "user_address AS userAddress,\n" +
            "user_id_card_address AS idCardAddress,\n" +
            "signup_method AS method,\n" +
            "user_password AS userPassword,\n" +
            "user_salt AS userSalt" +
            " from demo_user_info where signup_method = #{method} and user_phone = #{userPhone}")
    @ResultType(User.class)
    public List<User> getMethodAndPhone(String method,String userPhone);

    @Select("select id,\n" +
            "user_phone AS userPhone,\n" +
            "user_mail AS userMail,\n" +
            "user_number AS userNumb,\n" +
            "user_sex AS userSex,\n" +
            "user_birth_date AS userbirthDate,\n" +
            "user_nationality AS userNationality,\n" +
            "user_address AS userAddress,\n" +
            "user_id_card_address AS idCardAddress,\n" +
            "signup_method AS method,\n" +
            "user_password AS userPassword,\n" +
            "user_salt AS userSalt" +
            " from demo_user_info where signup_method = #{method} and user_mail = #{userMail}")
    @ResultType(User.class)
    public List<User> getMethodAndMail(String method,String userMail);

    @Select("select id,\n" +
            "user_id AS userId,\n" +
            "user_ip AS userIp,\n" +
            "user_login_times AS loginTimes from demo_operation_info where user_id = #{id}")
    @ResultType(Operation.class)
    public List<Operation> getPoerationByLoginTimes(Integer id);

    @Update("update demo_operation_info set user_login_times = #{loginTimes} where user_id = #{id}")
    @ResultType(Operation.class)
    public void updateOperation(Integer id,Integer loginTimes);

    @Insert("Insert into demo_operation_info(user_id,user_ip,user_login_times) values(#{id},null,#{loginTimes})")
    @ResultType(Operation.class)
    public void addOperation(Integer id,Integer loginTimes);
    
    @Update("update demo_user_info set user_name = #{userName},user_sex = #{userSex},user_birth_date = #{userbirthDate},user_nationality = #{userNationality},user_address = #{userAddress},user_phone = #{userPhone},user_mail = #{userMail} ,user_id_card_address = #{idCardAddress} where id = #{id}")
    @ResultType(User.class)
    public int addUserInfromation(String userName, String userSex, String userbirthDate, String userNationality, String userAddress, String userPhone, String userMail, String idCardAddress, Integer id);
}
