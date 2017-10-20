package com.caoyl.lfi.rest;


import com.caoyl.lfi.bean.UserBean;
import com.caoyl.lfi.dao.impl.UserDaoImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户资源
 * 2014-3-19
 */
@Path("/users")
public class UserResource {
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	/**
	 * 增加
	 * @param userBean
	 */
	@POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void createUser(UserBean userBean)
    {
		userDaoImpl.createUser(userBean);
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
     * @param userBean
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void updateUser(UserBean userBean){
		userDaoImpl.updateUser(userBean);
    }
 
    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public UserBean getUserById(@PathParam("id") String id){
    	UserBean u = userDaoImpl.getUserById(id);
    	return u;
    }
   
    /**
     * 查询所有
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<UserBean> getAllUsers(){
    	List<UserBean> userEntities = new ArrayList<UserBean>();
    	userEntities = userDaoImpl.getAllUsers();
        return userEntities;
    }
    
    
}
