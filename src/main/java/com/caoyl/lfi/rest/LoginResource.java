package com.caoyl.lfi.rest;

import com.caoyl.lfi.bean.BaseBean;
import com.caoyl.lfi.bean.LoginBean;
import com.caoyl.lfi.bean.UserBean;
import com.caoyl.lfi.dao.impl.UserDaoImpl;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("login")
public class LoginResource extends BaseResouce {
    UserDaoImpl userDao = new UserDaoImpl();

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public BaseBean<UserBean> login(LoginBean loginBean) {
        BaseBean<UserBean> baseBean = new BaseBean<UserBean>();
        if (loginBean != null) {
            UserBean userBean = userDao.getUserWithUserNameAndPwd(loginBean.getUserName(), loginBean.getPassword());
            if (userBean == null) {
                baseBean.setCode(502);
                baseBean.setMsg("用户名不存在");
                baseBean.setData(null);
            } else {
                String buildToken = createToken(loginBean.getUserName(), loginBean.getPassword());
                userBean.setToken(buildToken);
                boolean result = userDao.updateUser(userBean);
                if (result) {
                    baseBean.setCode(503);
                    baseBean.setMsg("登录失败");
                    baseBean.setData(userBean);
                } else {
                    baseBean.setCode(503);
                    baseBean.setMsg("登录失败");
                    baseBean.setData(null);
                }
            }
        } else {
            baseBean.setCode(501);
            baseBean.setMsg("用户名和密码不能为空");
            baseBean.setData(null);
        }

        return baseBean;
    }
}
