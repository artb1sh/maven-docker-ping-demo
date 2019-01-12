package com.bee42.ping.tomcat;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.Wrapper;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Popup Tomcat and install jersey 2 app
 * @author peter
 * @since 11.08.14
 */
public class StartService {

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        File base = new File(System.getProperty("java.io.tmpdir"));
        Context rootCtx = tomcat.addContext("/", base.getAbsolutePath());
        Wrapper wrapper = Tomcat.addServlet(rootCtx, "jersey", new ServletContainer());
wrapper.addInitParameter("javax.ws.rs.Application","com.bee42.ping.tomcat.MyApplication");

wrapper.addInitParameter("jersey.config.disableMoxyJson.server","true");

wrapper.addInitParameter("jersey.config.server.provider.packages","com.bee42.ping.rest;org.codehaus.jackson.jaxrs");
        wrapper.addInitParameter("com.sun.jersey.api.json.POJOMappingFeature","true");
        wrapper.setLoadOnStartup(1);
        rootCtx.addServletMapping("/rest/*", "jersey");
        tomcat.start();
        tomcat.getServer().await();
    }
}
