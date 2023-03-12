package com.springular.server.configurations;

import com.springular.server.entities.Category;
import com.springular.server.entities.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class CustomDataRestConfiguration implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnsupportedMethods = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH};
        setHttpMethodsForEntity(theUnsupportedMethods, config, Product.class);
        setHttpMethodsForEntity(theUnsupportedMethods, config, Category.class);
    }

    private static void setHttpMethodsForEntity(HttpMethod[] theUnsupportedMethods, RepositoryRestConfiguration config, Class<?> className) {

        config.getExposureConfiguration()
                .forDomainType(className)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedMethods)));
    }
}
