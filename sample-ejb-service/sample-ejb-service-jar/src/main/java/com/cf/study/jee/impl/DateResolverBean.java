package com.cf.study.jee.impl;

import java.util.Date;

import javax.ejb.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cf.study.jee.api.DateResolver;

@Singleton
public class DateResolverBean implements DateResolver {

    Logger logger = LoggerFactory.getLogger(getClass());

    public Date resolveCurrentDate() {
        logger.info("================== JAR Module");
        logger.info("CLASS LOADER: {}({})", getClass().getClassLoader(), getClass().getClassLoader().hashCode());
        logger.info("CONTEXT CLASS LOADER: {}({})", Thread.currentThread().getContextClassLoader(), Thread.currentThread().getContextClassLoader().hashCode());
        return new Date();
    }

}
