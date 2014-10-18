package com.cf.study.jee.ejb.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Startup
public class ServiceStartupBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostConstruct
    void onServiceStart() {
        logger.info("Starting service");
    }

    @PreDestroy
    void onServiceStop() {
        logger.info("Stopping service");
    }

}
