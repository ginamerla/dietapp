package com.tortu.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DietAppApplication extends SpringBootServletInitializer {
    private static final Logger LOG = LoggerFactory.getLogger(DietAppApplication.class);

    public static void main(String... arguments) {
        LOG.info("Starting DietApp application with Spring boot...");
        new SpringApplicationBuilder(DietAppApplication.class).run(arguments);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DietAppApplication.class);
    }
}
