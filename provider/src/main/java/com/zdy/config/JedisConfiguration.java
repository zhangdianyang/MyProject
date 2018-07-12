package com.zdy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zdy
 */
@Component
@ConfigurationProperties(prefix = "spring.redis.pool")
public class JedisConfiguration {

    private String host;
    private int port;
    private String password;
    private Integer maxTotal;
    private Integer maxIdle;
    private Integer minIdle;
    private Long maxWaitMillis;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean testWhileIdle;
}
