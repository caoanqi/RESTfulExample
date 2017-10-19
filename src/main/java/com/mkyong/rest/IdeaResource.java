package com.mkyong.rest;

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
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public List<IdeaBean> getAll() {
        List<IdeaBean> ideaBeans;
        ideaBeans = ideaDao.getAllIdeas();
        return ideaBeans;
    }
}
