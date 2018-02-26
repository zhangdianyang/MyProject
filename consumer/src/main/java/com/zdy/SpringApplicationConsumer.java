package com.zdy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zdy
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@ImportResource(value = {"classpath:consumer.xml"})
public class SpringApplicationConsumer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringApplicationConsumer.class, args);
    }
}
