package com.cf.study.jee.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Singleton;
import javax.enterprise.inject.Alternative;

import com.cf.study.jee.api.DateResolver;

@Alternative
@Singleton
public class MockDateResolverBean implements DateResolver {

    public Date resolveCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        String dateInString = "22-04-1989";
        try {
            return sdf.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
