package pl.sda.school.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:/application.properties"),
        @PropertySource(value = "file:${HOMEPATH}/application.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "file:${HOME}/application.properties", ignoreResourceNotFound = true)})
public class ApplicationConfig {
}

