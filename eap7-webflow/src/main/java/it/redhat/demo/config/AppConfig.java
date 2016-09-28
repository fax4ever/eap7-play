package it.redhat.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by fabio on 27/09/16.
 */
@Configuration
@ComponentScan(basePackages = "it.redhat.demo")
@Import(value={
    WebMvcConfig.class,
    WebFlowConfig.class
})
public class AppConfig {
}
