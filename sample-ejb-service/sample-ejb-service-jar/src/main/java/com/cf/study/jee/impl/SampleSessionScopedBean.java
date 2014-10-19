/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2012
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.cf.study.jee.impl;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class SampleSessionScopedBean extends AbstractManagedBean implements Serializable {

    private static final long serialVersionUID = 3328398785798428771L;

    @Override
    public String getState() {
        return "SESSION SCOPED BEAN: " + super.getState();
    }

}
