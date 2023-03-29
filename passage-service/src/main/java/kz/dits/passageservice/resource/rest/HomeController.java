package kz.dits.passageservice.resource.rest;

import kz.dits.passageservice.config.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
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

    @GetMapping("/passages")
    public List<String> getPassages(@RequestParam Integer count) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(UUID.randomUUID().toString());
        }
        return list;
    }

}
