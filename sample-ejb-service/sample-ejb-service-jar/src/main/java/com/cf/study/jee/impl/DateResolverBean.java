package com.cf.study.jee.impl;

import java.util.Date;

import javax.ejb.Singleton;

@Singleton
public class DateResolverBean {

    public Date resolveCurrentDate() {
        return new Date();
    }

}
