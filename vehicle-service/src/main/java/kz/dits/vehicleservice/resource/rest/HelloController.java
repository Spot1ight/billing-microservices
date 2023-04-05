package kz.dits.vehicleservice.resource.rest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import kz.dits.vehicleservice.client.PassageFeignClient;
import kz.dits.vehicleservice.config.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HelloController {

    @Autowired
    private ApplicationProperties props;
    private final PassageFeignClient passageFeignClient;


    @GetMapping("/hello")
    @RateLimiter(name = "vehicle-hello-limiter", fallbackMethod = "vehicleHelloLimiterFallback")
    public String hello() {
        return props.getHello();
    }

    private String vehicleHelloLimiterFallback(Throwable t) {
        return "Hello limiter fallback!";
    }

    @GetMapping("/shared")
    public String shared() { return props.getShared();}

    @GetMapping("/vehicle-passages/{count}")
    @CircuitBreaker(name = "vehicle-passage-breaker", fallbackMethod = "getVehiclePassagesFallback")
    @Retry(name = "vehicle-passage-retry", fallbackMethod = "getVehiclePassagesFallback")
    public Map<Integer, String> getVehiclePassages(@PathVariable Integer count) {
        log.info("REST GET request to get all passages!");
        List<String> list = passageFeignClient.getAllPassages(count);
        log.info("List of passages: {}", list);
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            map.put(i, list.get(i));
        }
        return map;
    }

    private Map<Integer, String> getVehiclePassagesFallback(Integer count, Throwable t) {
        Map<Integer, String> map = new HashMap<>();
        map.put(501,"Fallback fetched!");
        return map;
    }

}
