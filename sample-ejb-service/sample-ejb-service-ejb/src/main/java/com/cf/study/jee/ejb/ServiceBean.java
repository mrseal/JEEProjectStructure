package com.cf.study.jee.ejb;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cf.study.jee.api.ServiceLocal;
import com.cf.study.jee.api.ServiceRemote;
import com.cf.study.jee.impl.DateResolverBean;

@Stateless
public class ServiceBean implements ServiceRemote, ServiceLocal {

    private static final String DATE_FORMAT = "dd/MM/yyyy";

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private DateResolverBean dateResolver;

    public String resolveDate() {
        logger.debug("In EJB - resolving date");
        final DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        return df.format(dateResolver.resolveCurrentDate());
    }

}
