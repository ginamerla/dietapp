package com.tortu.api.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.tortu.api.rest.restservices.UsuarioRestService;
import com.tortu.api.utils.CustomFasterJacksonObjectMapperFactory;
import com.tortu.api.utils.ExceptionMapperImplementation;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.RuntimeDelegate;
import java.util.Arrays;

/**
 * Configuracion de JaxRS y todos los beans a exponer como REST Services
 */
@Order(2)
@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
@PropertySource({ "classpath:application.properties" })
public class JaxRsServerConfig {

    private static final Logger LOG = LoggerFactory.getLogger(JaxRsServerConfig.class);


    @Autowired
    private ApplicationContext applicationContext;

    /**
     * Default Jackson ObjectMapper.
     *
     * @return ObjectMapper bean.
     */
    @Bean
    public ObjectMapper objectMapper() {
        return new CustomFasterJacksonObjectMapperFactory().createCustomObjectMapper();
    }

    /**
     * Default Jackson JSON Provider.
     *
     * @return JacksonJsonProvider bean.
     */
    @Bean
    public JacksonJsonProvider jsonProvider() {
        final ObjectMapper strictObjectMapper = new CustomFasterJacksonObjectMapperFactory().createCustomObjectMapper();
        strictObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        return new JacksonJsonProvider(strictObjectMapper);
    }

    /**
     * The Server bean which defines which controllers and providers are used by
     * this service.
     *
     * @return Server bean.
     */
    @Bean
    public Server jaxRsServer() {
        final Bus bus = (Bus) applicationContext.getBean(Bus.DEFAULT_BUS_ID);

        final JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance()
                .createEndpoint(dietAppApiV1Application(),
                        JAXRSServerFactoryBean.class);
        factory.setServiceBeans(Arrays.<Object> asList(usuarioRestService()));
        factory.setAddress(factory.getAddress());
        factory.setProviders(Arrays.<Object> asList(jsonProvider(), exceptionMapper()));
        factory.setBus(bus);
        LOG.debug("JaxRsServerConfig : jaxRsServer bean created");
        return factory.create();
    }

    /**
     * Default Application for this service.
     *
     * @return DietAppApiV1Application bean.
     */
    @Bean
    public DietAppApiV1Application dietAppApiV1Application() {
        LOG.debug("JaxRsServerConfig : DietAppApiV1Application bean created");
        return new DietAppApiV1Application();
    }
/**
 * --------------------------------------------------------------------------------
 * Agregar los demas servicios REST y agregar a la lista dentro de JaxRsServer()
 * --------------------------------------------------------------------------------
 */
    /**
     * Controller for UsuarioController functionality.
     *
     * @return UsuarioController bean.
     */
    @Bean
    public UsuarioRestService usuarioRestService() {
        LOG.debug("JaxRsServerConfig : UsuarioRestService bean created");
        return new UsuarioRestService();
    }


    /**
     * Gets the {@link ExceptionMapper}.
     *
     * @return the ExceptionMapper
     */
    @Bean
    public ExceptionMapper<Exception> exceptionMapper() {
        return new ExceptionMapperImplementation();
    }
}
