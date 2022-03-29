package com.example;

import io.quarkus.logging.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class ExampleResource {

    @RequestMapping(value = {"/",""}, method = RequestMethod.GET)
    public String hello() {
        Log.info("test log");
        return "Hello Spring";
    }
}
