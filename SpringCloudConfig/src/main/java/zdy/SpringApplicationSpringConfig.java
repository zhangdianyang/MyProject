package zdy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zdy
 */

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class SpringApplicationSpringConfig {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringApplicationSpringConfig.class, args);
    }

}
