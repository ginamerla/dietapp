package com.tortu.api.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Clase para agregar mas mappers al momento de serializar cualquier objeto Json.
 * @author visilva
 */
public class CustomFasterJacksonObjectMapperFactory {

    /**
     * Creates a custom {@link ObjectMapper}. In this particular case, the
     * object mapper provides custom mapping for {@link LocalDate},
     * {@link LocalTime} and {@link LocalDateTime} objects,
     * letting all remaining objects be handled by the default implementation.
     *
     * @return {@link ObjectMapper} instance
     */
    public ObjectMapper createCustomObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        // Add Java 8 date/time serializers and deserializers
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
        objectMapper.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // Module to speed up Faster Jackson even more (through bytecode
        // interaction)
        objectMapper.registerModule(new AfterburnerModule());

        return objectMapper;
    }
}
