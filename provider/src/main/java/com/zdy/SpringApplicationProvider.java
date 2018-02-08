package com.zdy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zdy
 */
@SpringBootApplication
@ImportResource(value = {"classpath:provider.xml"})
@MapperScan("com.zdy.dao")
public class SpringApplicationProvider {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringApplicationProvider.class, args);
    }
}
