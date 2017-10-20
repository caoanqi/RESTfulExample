package com.caoyl.lfi.bean;

import javax.xml.bind.annotation.XmlRootElement;

/* *
 * 用户 bean 
 * @author waylau.com
 * 2014-7-24
 */
@XmlRootElement
public class UserBean {

    private String userId;
    private String userName;
    private String age;
    private String password;
    private String nickName;
    private String token;

    public UserBean() {
    }

    public UserBean(String userId, String userName, String age, String password,String token) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.password = password;
        this.token=token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}  