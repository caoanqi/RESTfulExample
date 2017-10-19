package com.mkyong.dao;


import com.mkyong.bean.UserEntity;

import java.util.List;


/**
 * UserEntity Dao 接口
 * @author waylau.com
 * 2014-3-18
 */
public interface UserDao {
	
	public UserEntity getUserById(String id);

	public boolean deleteUserById(String id);

	public boolean createUser(UserEntity userEntity);

	public boolean updateUser(UserEntity userEntity);

	public List<UserEntity> getAllUsers();
}
