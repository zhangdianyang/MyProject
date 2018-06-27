package com.zdy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zdy
 */
@SpringBootApplication
//@ImportResource(value = {"classpath:provider.xml"})
@EnableEurekaClient
public class SpringApplicationProviderBak {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringApplicationProviderBak.class, args);
    }
}
