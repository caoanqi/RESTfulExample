package com.mkyong.rest;

import com.mkyong.bean.BaseModel;
import com.mkyong.bean.IdeaBean;
import com.mkyong.dao.impl.IdeaDaoImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Path("/idea")
public class IdeaResource {

    private IdeaDaoImpl ideaDao = new IdeaDaoImpl();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public BaseModel<List<IdeaBean>> getAll() {
        BaseModel<List<IdeaBean>> listBaseModel = new BaseModel<List<IdeaBean>>();
        listBaseModel.setCode(200);
        listBaseModel.setMsg("success");
        listBaseModel.setData(ideaDao.getAllIdeas());
        return listBaseModel;
    }
}
