package com.cf.study.jee.test.jee;

import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;

/**
 * Maven artifact constants for JEE tests
 */
public class Artifact {

    //    public static final String COM_ANY_JAR = "com.cf.study:cf-dist:jar";

    public static MavenDependencyResolver getMavenResolver() {
        return DependencyResolvers.use(MavenDependencyResolver.class).loadMetadataFromPom("pom.xml");
    }

}