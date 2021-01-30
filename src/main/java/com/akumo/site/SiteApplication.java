package com.akumo.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.akumo.site")
@SpringBootApplication(scanBasePackages = {"com.akumo.site"})
@EnableJpaRepositories(basePackages = "com.akumo.site.domain")
@EntityScan(basePackages = "com.akumo.site.domain.entities")
public class SiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiteApplication.class, args);
    }

}
