package com.caoyl.lfi.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 登录参数
 */
public class LoginBean {
    private String userName;
    private String password;
    private String deviceId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
