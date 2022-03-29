package com.example;

import io.quarkus.logging.Log;
import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class ExampleResource {

    @Location("pages/hello.html")
    private Template hello;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET, produces = {MediaType.TEXT_PLAIN_VALUE})
    public String test(@RequestParam(value = "name", defaultValue = "") String name) {
        Log.info("test: " + name);
        return "Hello " + name;
    }

    @RequestMapping(value = {"/say-hello"}, method = RequestMethod.GET, produces = {MediaType.TEXT_HTML_VALUE})
    public TemplateInstance sayHello(@RequestParam(value = "name", defaultValue = "") String name) {
        Log.info("hello: " + name);
        return hello.data("name", name);
    }
}
