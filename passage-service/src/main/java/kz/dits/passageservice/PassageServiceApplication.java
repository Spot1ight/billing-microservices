package kz.dits.passageservice;

import kz.dits.passageservice.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
@EnableEurekaClient
@EnableFeignClients
public class PassageServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(PassageServiceApplication.class, args);
    }

}
