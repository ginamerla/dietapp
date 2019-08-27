package com.tortu.api.configuration;

import com.tortu.api.services.UsuarioService;
import com.tortu.api.services.impl.FakeUsuarioServiceImpl;
import com.tortu.api.services.impl.UsuarioServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

/**
 * Configuracion de beans. Esta clase incluira todas los beans que se necesitan inyectar sus dependencias.
 * @author visilva
 */
@Order(1)
@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
@PropertySource({ "classpath:application.properties" })
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAutoConfiguration
public class DietAppConfig {
    private static Logger LOG = LoggerFactory.getLogger(DietAppConfig.class);

    /**
     * Crea una instance singleton de Usuario service.
     * En este caso estamos inyectando la implementacion "Fake" de usuario.
     * @return una implementacion de Usuario Service.
     */
    @Bean("fakeUsuarioService")
    public UsuarioService fakeUsuarioService() {
        LOG.info(String.format("Bean [ %s ] initicializado!", "FakeUsuarioServiceImpl"));
        return new FakeUsuarioServiceImpl();
    }

    @Bean
    public UsuarioService usuarioService() {
        LOG.info(String.format("Bean [ %s ] initicializado!", "UsuarioServiceImpl"));
        return new UsuarioServiceImpl();
    }
}
