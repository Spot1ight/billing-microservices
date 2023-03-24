package kz.dits.vehicleservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableConfigurationProperties(ApplicationProperties.class)
@EnableEurekaClient
public class VehicleServiceApplication {

    @Autowired
    private ApplicationProperties props;

    @GetMapping("/hello")
    public String hello() {
        return props.getHello();
    }

    @GetMapping("/shared")
    public String shared() { return props.getShared();}

    public static void main(String[] args) {
        SpringApplication.run(VehicleServiceApplication.class, args);
    }

}
