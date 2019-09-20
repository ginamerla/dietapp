package com.tortu.api.configuration;

import com.tortu.api.daos.CategoriaIngredienteDao;
import com.tortu.api.daos.RecetaDao;
import com.tortu.api.daos.UsuarioDao;
import com.tortu.api.daos.impl.CategoriaIngredienteDaoImpl;
import com.tortu.api.daos.impl.RecetaDaoImpl;
import com.tortu.api.daos.impl.UsuarioDaoImpl;
import com.tortu.api.services.CategoriaIngredienteService;
import com.tortu.api.services.RecetaService;
import com.tortu.api.services.UsuarioService;
import com.tortu.api.services.impl.CategoriaIngredienteServiceImpl;
import com.tortu.api.services.impl.RecetaServiceImpl;
import com.tortu.api.services.impl.UsuarioServiceImpl;
import org.mariadb.jdbc.MariaDbDataSource;
import org.mariadb.jdbc.MySQLDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Configuracion de beans. Esta clase incluira todas los beans que se necesitan inyectar sus dependencias.
 * Aqui se declaran los DAOs y Services.
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

    @Value("${db.url}")
    private String jdbcUrl;

    @Value("${db.username}")
    private String jdbcUsername;

    @Value("${db.password}")
    private String jdbcPassword;

    @Bean
    public DataSource dataSource() throws SQLException{
        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl(jdbcUrl);
        dataSource.setUserName(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        LOG.info("MariaDB URL: "+jdbcUrl);
        return dataSource;
    }

    /** ----------------------------------------------------
     * Se crean las instancias singleton de Services y DAOs
     -------------------------------------------------------
     */

    @Bean
    public UsuarioService usuarioService() {
        LOG.info(String.format("Bean [ %s ] initialized!", "UsuarioServiceImpl"));
        return new UsuarioServiceImpl();
    }
    @Bean
    public UsuarioDao usuarioDao(){
        return new UsuarioDaoImpl();
    }
    @Bean
    public RecetaService recetaService(){
        LOG.info(String.format("Bean [ %s ] initialized!", "RecetaServiceImpl"));
        return new RecetaServiceImpl();
    }
    @Bean
    public RecetaDao recetaDao(){
        return new RecetaDaoImpl();
    }
    @Bean
    public CategoriaIngredienteService categoriaIngredienteService(){
        LOG.info(String.format("Bean [ %s ] initialized!","CategoriaIngredienteServiceImpl"));
        return new CategoriaIngredienteServiceImpl();
    }
    @Bean
    public CategoriaIngredienteDao categoriaIngredienteDao(){
        return new CategoriaIngredienteDaoImpl();
    }
}