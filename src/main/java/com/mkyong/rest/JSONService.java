package com.mkyong.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mkyong.bean.BaseModel;
import com.mkyong.bean.Track;

@Path("/json/metallica")
public class JSONService {

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public BaseModel getTrackInJSON() {
        Track track = new Track();
        track.setTitle("Enter Sandman");
        track.setSinger("Metallica");
        BaseModel model=new BaseModel();
        model.setCode(200);
        model.setMsg("success");
        model.setData(track);


        return model;

    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(Track track) {

        String result = "Track saved : " + track;
        return Response.status(201).entity(result).build();

    }

}