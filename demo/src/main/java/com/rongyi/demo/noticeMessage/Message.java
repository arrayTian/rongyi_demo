package com.rongyi.demo.noticeMessage;

import com.rongyi.demo.entity.ClientInfo;

import java.util.List;

public class Message {
    private String code;
    private List<ClientInfo> data;
    private String MyName;



    public String getMyName() {
        return MyName;
    }

    public void setMyName(String myName) {
        MyName = myName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ClientInfo> getData() {
        return data;
    }

    public void setData(List<ClientInfo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Message{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", MyName='" + MyName + '\'' +
                '}';
    }
}
