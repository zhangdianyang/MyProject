package com.zdy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zdy
 */
@SpringBootApplication
@ComponentScan
@EnableCaching
@ImportResource(value = {"classpath:provider.xml"})
@MapperScan("com.zdy.dao")
@EnableTransactionManagement
@EnableAsync
public class SpringApplicationProvider {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringApplicationProvider.class, args);
    }
}
