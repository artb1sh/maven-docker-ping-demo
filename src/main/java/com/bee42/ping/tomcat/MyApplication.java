package com.bee42.ping.tomcat;

import org.glassfish.jersey.server.ResourceConfig ;
import org.glassfish.jersey.jackson.JacksonFeature;

public class MyApplication extends ResourceConfig {

    public MyApplication() {
        register(JacksonFeature.class);
    }
}
