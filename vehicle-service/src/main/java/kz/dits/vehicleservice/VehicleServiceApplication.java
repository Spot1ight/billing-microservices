package kz.dits.vehicleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VehicleServiceApplication {

    @GetMapping
    public String hello() {
        return "Hello from vehicle-service!";
    }

    public static void main(String[] args) {
        SpringApplication.run(VehicleServiceApplication.class, args);
    }

}
