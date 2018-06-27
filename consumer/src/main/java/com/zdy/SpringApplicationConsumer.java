package com.zdy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

/**
 * @author zdy
 */
@SpringBootApplication
@ImportResource(value = {"classpath:consumer.xml"})
//@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class SpringApplicationConsumer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringApplicationConsumer.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
