package com.mkyong.dao;


import com.mkyong.bean.UserBean;

import java.util.List;


/**
 * UserBean Dao 接口
 * @author waylau.com
 * 2014-3-18
 */
public interface UserDao {
	
	public UserBean getUserById(String id);

	public boolean deleteUserById(String id);

	public boolean createUser(UserBean userBean);

	public boolean updateUser(UserBean userBean);

	public List<UserBean> getAllUsers();
}
