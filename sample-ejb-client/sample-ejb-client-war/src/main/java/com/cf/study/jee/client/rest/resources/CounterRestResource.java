package com.cf.study.jee.client.rest.resources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.cf.study.jee.api.ServiceRemote;

/*
 * Rest Services 
 *  
 * Resources are served relative to the servlet path specified in the {@link ApplicationPath}
 * annotation.
 */
@Path("/resource")
@RequestScoped
public class CounterRestResource {

    // @EJB itself can not be used to inject a remote EJB in a different application (EAR/WAR)
    // Use "lookup" property to lookup a exact remote EJB instance
    @EJB(lookup = "java:global/sample-ejb-service-ear-1.0.1-SNAPSHOT/sample-ejb-service-ejb-1.0.1-SNAPSHOT/ServiceBean!com.cf.study.jee.api.ServiceRemote")
    private ServiceRemote service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("date")
    public String getDate() {
        return service.resolveDate();
    }

}