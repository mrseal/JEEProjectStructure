package com.cf.study.jee.ejb;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cf.study.jee.api.*;
import com.cf.study.jee.impl.*;

@Stateless
public class ServiceBean implements ServiceRemote, ServiceLocal {

    private static final String DATE_FORMAT = "dd/MM/yyyy";

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private DateResolver dateResolver;

    @Inject
    private SampleDefaultScopedBean defaultScopedBean;

    @Inject
    private SampleRequestScopedBean requestScopedBean;

    @Inject
    private SampleSessionScopedBean sessionScopedBean;

    public String resolveDate() {

        logger.info("================== EJB Module");
        logger.info("CLASS LOADER: {}({})", getClass().getClassLoader(), getClass().getClassLoader().hashCode());
        logger.info("CONTEXT CLASS LOADER: {}({})", Thread.currentThread().getContextClassLoader(), Thread.currentThread().getContextClassLoader().hashCode());

        logger.debug("In EJB - resolving date");
        final DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        return df.format(dateResolver.resolveCurrentDate()) + " " + defaultScopedBean.getState() + " " + requestScopedBean.getState() + " " + sessionScopedBean.getState();
    }
}
