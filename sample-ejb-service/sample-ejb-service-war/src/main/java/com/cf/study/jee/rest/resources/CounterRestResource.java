package com.cf.study.jee.rest.resources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.cf.study.jee.api.ServiceLocal;

/*
 * Rest Services 
 *  
 * Resources are served relative to the servlet path specified in the {@link ApplicationPath}
 * annotation.
 */
@Path("/resource")
@RequestScoped
public class CounterRestResource {

    @EJB
    private ServiceLocal service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("date")
    public String getDate() {
        return service.resolveDate();
    }

}