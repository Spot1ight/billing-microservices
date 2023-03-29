package kz.dits.vehicleservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("passage-service")
public interface PassageFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/hello", consumes = "application/json")
    String getHelloPassages();

    @RequestMapping(method = RequestMethod.GET, value = "/passages", consumes = "application/json")
    List<String> getAllPassages(@RequestParam("count") Integer count);
}
