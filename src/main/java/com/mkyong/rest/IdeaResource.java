package com.mkyong.rest;

import com.mkyong.bean.BaseBean;
import com.mkyong.bean.IdeaBean;
import com.mkyong.dao.impl.IdeaDaoImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/idea")
public class IdeaResource {

    private IdeaDaoImpl ideaDao = new IdeaDaoImpl();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public BaseBean<List<IdeaBean>> getAll() {
        BaseBean<List<IdeaBean>> listBaseBean = new BaseBean<List<IdeaBean>>();
        listBaseBean.setCode(200);
        listBaseBean.setMsg("success");
        listBaseBean.setData(ideaDao.getAllIdeas());
        return listBaseBean;
    }
}
