package com.zdy;

import com.zdy.config.JedisConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zdy
 */
@SpringBootApplication
@ComponentScan
@EnableCaching
//@ImportResource(value = {"classpath:provider.xml"})
@MapperScan("com.zdy.dao")
@EnableTransactionManagement
@EnableAsync
@EnableEurekaClient
public class SpringApplicationProvider {

    @Autowired
    private JedisConfiguration jedisConfiguration;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringApplicationProvider.class, args);
    }

}
