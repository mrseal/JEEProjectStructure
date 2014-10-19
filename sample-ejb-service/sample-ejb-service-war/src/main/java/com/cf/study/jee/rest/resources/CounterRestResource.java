package com.cf.study.jee.rest.resources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cf.study.jee.api.ServiceLocal;
import com.cf.study.jee.impl.*;

/*
 * Rest Services 
 *  
 * Resources are served relative to the servlet path specified in the {@link ApplicationPath}
 * annotation.
 */
@Path("/resource")
@RequestScoped
public class CounterRestResource {

    Logger logger = LoggerFactory.getLogger(getClass());

    @EJB
    private ServiceLocal service;

    @Inject
    private SampleDefaultScopedBean defaultScopedBean;

    @Inject
    private SampleRequestScopedBean requestScopedBean;

    @Inject
    private SampleSessionScopedBean sessionScopedBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("date")
    public String getDate() {
        logger.info("================== WAR Module");
        logger.info("CLASS LOADER: {}({})", getClass().getClassLoader(), getClass().getClassLoader().hashCode());
        logger.info("CONTEXT CLASS LOADER: {}({})", Thread.currentThread().getContextClassLoader(), Thread.currentThread().getContextClassLoader().hashCode());

        defaultScopedBean.changeState();
        requestScopedBean.changeState();
        sessionScopedBean.changeState();

        return service.resolveDate();
    }
}