package com.zdy;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zdy
 */
@SpringBootApplication
@ImportResource(value = {"classpath:provider.xml"})
public class SpringApplication {

    public static void main(String[] args) throws Exception {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
    }
}
