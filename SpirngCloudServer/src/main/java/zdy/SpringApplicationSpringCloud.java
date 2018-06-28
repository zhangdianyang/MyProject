package zdy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zdy
 */
@EnableEurekaServer
@SpringBootApplication
@EnableConfigServer
public class SpringApplicationSpringCloud {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringApplicationSpringCloud.class, args);
    }

}
