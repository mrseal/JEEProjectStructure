package com.cf.study.jee.impl;

import java.util.Date;

import javax.ejb.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class DateResolverBean {

    Logger logger = LoggerFactory.getLogger(getClass());

    public Date resolveCurrentDate() {
        logger.info("================== JAR Module");
        logger.info("CLASS LOADER: {}", getClass().getClassLoader().hashCode());
        logger.info("CONTEXT CLASS LOADER: {}", Thread.currentThread().getContextClassLoader().hashCode());
        return new Date();
    }

}
