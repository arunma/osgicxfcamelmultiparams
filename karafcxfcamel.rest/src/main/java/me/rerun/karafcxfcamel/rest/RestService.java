package me.rerun.karafcxfcamel.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public interface RestService {


    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public String sourceResultsFromTwoSources();

}
