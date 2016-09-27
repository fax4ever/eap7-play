package it.redhat.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.faces.mvc.JsfView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * Created by fabio on 27/09/16.
 */

@Configuration
@EnableWebMvc
public class WebMvcConfig {

    @Bean
    public UrlBasedViewResolver faceletsViewResolver() {
        UrlBasedViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}
