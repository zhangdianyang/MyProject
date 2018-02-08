package com.zdy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zdy
 */
@SpringBootApplication
@ImportResource(value = {"classpath:provider.xml"})
public class SpringApplicationProvider {

    public static void main(String[] args) throws Exception {
        org.springframework.boot.SpringApplication.run(SpringApplicationProvider.class, args);
    }
}
