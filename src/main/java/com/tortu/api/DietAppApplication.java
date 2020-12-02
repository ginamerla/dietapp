package com.tortu.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is where the magic happens, this is to tell spring to initialize the spring context and load all beans.
 */
@SpringBootApplication
public class DietAppApplication {
    private static final Logger LOG = LoggerFactory.getLogger(DietAppApplication.class);

    public static void main(String... arguments) {
        LOG.info("Starting DietApp application with Spring boot...");
        SpringApplication.run(DietAppApplication.class, arguments);
    }
}
