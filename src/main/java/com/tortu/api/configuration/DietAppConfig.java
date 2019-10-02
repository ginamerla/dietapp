package com.tortu.api.configuration;

import com.tortu.api.daos.*;
import com.tortu.api.daos.impl.*;
import com.tortu.api.services.*;
import com.tortu.api.services.impl.*;
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

    @Bean
    public IngredienteService ingredienteService(){
        LOG.info(String.format("Bean [ %s ] initialized", "IngredienteServiceImpl"));
        return new IngredienteServiceImpl();
    }
    @Bean
    public IngredienteDao ingredienteDao(){
        return new IngredienteDaoImpl();
    }

    @Bean
    public DietaUsuarioService dietaUsuarioService(){
        LOG.info(String.format("Bean [ %s ] initialized", "DietaUsuarioServiceImpl"));
        return new DietaUsuarioServiceImpl();
    }
    @Bean
    public DietaUsuarioDao dietaUsuarioDao(){
        return new DietaUsuarioDaoImpl();
    }

    @Bean
    public UsuarioLayoutService usuarioLayoutService(){
        LOG.info(String.format("Bean [ %s ] initialized", "UsuarioLayoutServiceImpl"));
        return new UsuarioLayoutServiceImpl();
    }
    @Bean UsuarioLayoutDao usuarioLayoutDao(){
        return new UsuarioLayoutDaoImpl();
    }

    @Bean
    public LayoutPeriodoService layoutPeriodoService(){
        LOG.info(String.format("Bean [ %s ] initialized", "LayoutPeriodoServiceImpl"));
        return new LayoutPeriodoServiceImpl();
    }
    @Bean
    public LayoutPeriodoDao layoutPeriodoDao(){
        return new LayoutPeriodoDaoImpl();
    }
}