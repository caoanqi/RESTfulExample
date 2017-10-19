package com.mkyong.rest;


import com.mkyong.bean.UserEntity;
import com.mkyong.dao.impl.UserDaoImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户资源
 * @author waylau.com
 * 2014-3-19
 */
@Path("/users")
public class UserResource {
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	/**
	 * 增加
	 * @param userEntity
	 */
	@POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createUser(UserEntity userEntity)
    {
		userDaoImpl.createUser(userEntity);
    }
	
	/**
	 * 删除
	 * @param id
	 */
    @DELETE
    @Path("{id}")
    public void deleteUser(@PathParam("id")String id){
    	userDaoImpl.deleteUserById(id);
    }
    
    /**
     * 修改
     * @param userEntity
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void updateUser(UserEntity userEntity){
		userDaoImpl.updateUser(userEntity);
    }
 
    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public UserEntity getUserById(@PathParam("id") String id){
    	UserEntity u = userDaoImpl.getUserById(id);
    	return u;
    }
   
    /**
     * 查询所有
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<UserEntity> getAllUsers(){
    	List<UserEntity> userEntities = new ArrayList<UserEntity>();
    	userEntities = userDaoImpl.getAllUsers();
        return userEntities;
    }
    
    
}
