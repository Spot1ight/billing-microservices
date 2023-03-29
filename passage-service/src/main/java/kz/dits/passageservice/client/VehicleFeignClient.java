package kz.dits.passageservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("vehicle-service")
public interface VehicleFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "hello", consumes = "application/json")
    String getVehicleHello();
}
