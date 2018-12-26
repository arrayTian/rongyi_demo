package com.rongyi.demo.dao.mapper;

import com.rongyi.demo.entity.ClientInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClientInfoMapper {


    List<ClientInfo> seachAll();
    List<ClientInfo> seachMyClient(int userId);
    List<ClientInfo> findClientInfoName(String clientInfoName);
    List<ClientInfo> searchLike(String searchName);
    List<ClientInfo> findClientInfoPhone(String clientInfoPhone);
    List<ClientInfo> findClientInfoEmail(String clientInfoEmail);
    public int insertUser(ClientInfo client);

}

