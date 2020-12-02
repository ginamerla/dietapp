package com.tortu.api.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {
    /**
     * enables logging filter.
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean loginFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new RequestResponseLoggingFilter());
        registration.addUrlPatterns("/*");
        registration.setName("loggingFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean authFilter(){
        FilterRegistrationBean authFilter = new FilterRegistrationBean();
        authFilter.setOrder(2);
        authFilter.setFilter(new TokenAuthFilter());
        authFilter.addUrlPatterns("/*");
        authFilter.setName("authFilter");
        return authFilter;
    }
}
