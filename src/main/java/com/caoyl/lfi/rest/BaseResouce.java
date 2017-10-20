package com.caoyl.lfi.rest;

import com.caoyl.lfi.bean.UserBean;
import com.caoyl.lfi.dao.impl.UserDaoImpl;
import com.caoyl.lfi.util.MD5Util;

public class BaseResouce {

    protected String createToken(String userName, String deviceId) {
        String token;
        if (userName.isEmpty() || deviceId.isEmpty()) {
            return null;
        } else {
            token = MD5Util.md5(userName + deviceId);
            return token;
        }
    }

    protected boolean checkToken(String userId, String token) {
        UserDaoImpl userDao = new UserDaoImpl();
        UserBean userBean = userDao.getUserById(userId);
        return userBean != null && userBean.getToken().equals(token);
    }
}
