package com.tortu.api.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Log4j2
@Provider
@PreMatching
@Priority(1)
public class RequestLoggerFilter implements ContainerRequestFilter {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request URL: ");
        stringBuilder.append(containerRequestContext.getUriInfo().getPath());
        stringBuilder.append(" Method: ");
        stringBuilder.append(containerRequestContext.getMethod());
        stringBuilder.append(" Headers: ");
        MultivaluedMap<String, String> headerNames = containerRequestContext.getHeaders();
        stringBuilder.append(objectMapper.writeValueAsString(headerNames));
        log.info(stringBuilder.toString());
    }
}
