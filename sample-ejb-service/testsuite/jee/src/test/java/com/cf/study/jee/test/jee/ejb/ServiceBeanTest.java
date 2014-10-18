
package com.cf.study.jee.test.jee.ejb;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cf.study.jee.api.Service;
import com.cf.study.jee.api.ServiceLocal;
import com.cf.study.jee.ejb.ServiceBean;
import com.cf.study.jee.impl.DateResolverBean;

/**
 * Arquillian test - Injecting EJB, Creating Archives and Libraries and test end-to-end
 * functionalities
 */
@RunWith(Arquillian.class)
public class ServiceBeanTest {

    @EJB
    private ServiceLocal serviceBean;

    @Deployment(name = "ServiceBeanEar")
    public static Archive<?> createTestArchive() {

        final EnterpriseArchive archive = ShrinkWrap.create(EnterpriseArchive.class, ServiceBeanTest.class.getSimpleName() + ".ear");
        archive.addAsModule(createModuleArchive());
        archive.addAsLibrary(createLibraryArchive());

        // Additional resources can be added into the archive.  e.g. JMS configuration file 
        // archive.addAsManifestResource("test-channels-jms.xml");

        // Using MavenDependencyResolver to resolve dependencies in pom.xml
        // final MavenDependencyResolver resolver = Artifact.getMavenResolver();
        // archive.addAsLibraries(resolver.artifact(Artifact.COM_ANY_JAR).resolveAsFiles());

        return archive;
    }

    private static Archive<?> createModuleArchive() {
        final JavaArchive archive = ShrinkWrap.create(JavaArchive.class, ServiceBeanTest.class.getSimpleName() + "-ejb.jar");
        // The ServiceFrameworkConfiguration.properties and beans.xml is required by Service Framework
        archive.addAsResource("META-INF/beans.xml", "META-INF/beans.xml");
        archive.addClass(ServiceBean.class).addPackage(ServiceBean.class.getPackage().getName());
        return archive;
    }

    private static Archive<?> createLibraryArchive() {
        final JavaArchive archive = ShrinkWrap.create(JavaArchive.class, ServiceBeanTest.class.getSimpleName() + "-lib.jar");
        archive.addAsResource("META-INF/beans.xml", "META-INF/beans.xml");
        archive.addClass(ServiceLocal.class).addPackage(ServiceLocal.class.getPackage().getName());
        archive.addClass(ServiceBeanTest.class).addPackage(Service.class.getPackage().getName());
        archive.addClass(DateResolverBean.class).addPackage(DateResolverBean.class.getPackage().getName());
        return archive;
    }

    /*
     * To Test serviceBean
     */
    @Test
    public void test() {
        Assert.assertNotNull("ServiceBean should not be null", serviceBean);
        Assert.assertNotNull("Resolved date should not be null", serviceBean.resolveDate());
    }

}