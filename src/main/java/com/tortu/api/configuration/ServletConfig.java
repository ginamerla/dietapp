package com.tortu.api.configuration;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.ErrorPageFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.filter.DelegatingFilterProxy;

@Configuration
@ImportResource({ "classpath:spring-security.xml" })
public class ServletConfig {
    /**
     * Remplaza el web.xml
     *
     * @param context
     *            the application context.
     * @return ServletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext context) {
        ServletRegistrationBean bean = new ServletRegistrationBean(new CXFServlet(), "/api/*");
        bean.setLoadOnStartup(1);
        return bean;
    }

    /**
     * Habilita spring security filter.
     *
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean springSecurityFilterChain() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new DelegatingFilterProxy());
        registration.addUrlPatterns("/*");
        registration.setName("springSecurityFilterChain");
        return registration;
    }

    /**
     * Bean de errorPage filter.
     *
     * @return ErrorPageFilter
     */
    @Bean
    public ErrorPageFilter errorPageFilter() {
        return new ErrorPageFilter();
    }

    /**
     * Deshabilita el error page filter.
     *
     * @param errorPageFilter
     *            an ErrorPageFilter.
     *
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean disableSpringBootErrorFilter(final ErrorPageFilter errorPageFilter) {
        final FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(errorPageFilter);
        filterRegistrationBean.setEnabled(false);
        return filterRegistrationBean;
    }
}
