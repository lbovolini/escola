package com.github.lbovolini.escola.config;

import org.glassfish.jersey.server.ResourceConfig;

public class JerseyApplication extends ResourceConfig {
    public JerseyApplication() {
        register(new DependencyBinder());
    }
}
