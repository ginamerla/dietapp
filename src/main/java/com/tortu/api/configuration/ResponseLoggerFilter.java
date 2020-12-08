package com.tortu.api.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Log4j2
@Provider
@Priority(3)
public class ResponseLoggerFilter implements ContainerResponseFilter {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        MultivaluedMap<String, String> headerNames = containerResponseContext.getStringHeaders();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Response Status: ");
        stringBuilder.append(containerResponseContext.getStatus());
        stringBuilder.append(" Headers: ");
        stringBuilder.append(objectMapper.writeValueAsString(headerNames));
        stringBuilder.append(" Payload: ");
        stringBuilder.append(objectMapper.writeValueAsString(containerResponseContext.getEntity()));
        log.info(stringBuilder.toString());
    }

}
