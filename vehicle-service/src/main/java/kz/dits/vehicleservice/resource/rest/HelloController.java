package kz.dits.vehicleservice.resource.rest;

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
    public String hello() {
        return props.getHello();
    }

    @GetMapping("/shared")
    public String shared() { return props.getShared();}

    @GetMapping("/vehicle-passages/{count}")
    public Map<Integer, String> getVehiclePassages(@PathVariable Integer count) {
        List<String> list = passageFeignClient.getAllPassages(count);
        log.info("List of passages: {}", list);
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            map.put(i, list.get(i));
        }
        return map;
    }

}
