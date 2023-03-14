package kz.dits.vehicleservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VehicleServiceApplication {
    @Value("${hello}")
    private String hello;
    @Value("${shared}")
    private String shared;

    @GetMapping("/hello")
    public String hello() {
        return hello;
    }

    @GetMapping("/shared")
    public String shared() { return shared;}

    public static void main(String[] args) {
        SpringApplication.run(VehicleServiceApplication.class, args);
    }

}
