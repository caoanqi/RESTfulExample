package com.mkyong.rest;

import com.mkyong.bean.UserBean;
import com.mkyong.dao.impl.UserDaoImpl;
import com.mkyong.util.MD5Util;
import javafx.scene.text.Text;
import sun.security.provider.MD5;

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
