package kz.dits.passageservice.resource.rest;

import io.micrometer.core.annotation.Timed;
import kz.dits.passageservice.config.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HomeController {
    @Autowired
    private ApplicationProperties props;

    @GetMapping("/hello")
    public String hello() {
        return props.getHello();
    }

    @GetMapping("/roads")
    @Timed(value = "getRoads.time", description = "Time to taken roads!")
    public List<Integer> getRoads() {
        log.info("REST GET request to get roads!");
        return List.of(new Random().nextInt(),2,3,4,5,6,7,8,9,10);
    }

    @GetMapping("/passages")
    public List<String> getPassages(@RequestParam Integer count) {
        log.info("Requesting passages count: {}", count);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(UUID.randomUUID().toString());
        }
        log.info("Request finished!");
        return list;
    }

}
