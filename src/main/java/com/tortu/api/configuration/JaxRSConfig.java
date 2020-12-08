package com.tortu.api.configuration;

import com.tortu.api.rest.restservices.*;
import lombok.extern.log4j.Log4j2;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2
public class JaxRSConfig extends ResourceConfig {
    public JaxRSConfig() {
        log.info("Initializing Rest Services...");
        packages("com.tortu.api");
        register(UsuarioRestService.class);
        register(CategoriaIngredienteRestService.class);
        register(IngredienteRestService.class);
        register(DietaUsuarioRestService.class);
        register(UsuarioLayoutRestService.class);
        register(LayoutPeriodoRestService.class);
        register(RecetaPeriodoRestService.class);
        register(RecetaIngredienteRestService.class);
        register(ComboDietaUsuarioRestService.class);
        register(ShoppingIngredientRestService.class);
        register(WeeklyPlanRestService.class);
        log.info("All Rest services - Added!");
    }
}
