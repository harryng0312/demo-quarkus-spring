package org.harryng.demo.quarkusspring.controller;

import io.quarkus.logging.Log;
import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

@RestController
@RequestMapping({"/", "", "/index"})
public class IndexController {

    @Location("pages/index.html")
    private Template indexTempl;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init(){
        Log.info("Index Controller init");
    }

    @PreDestroy
    public void destroy(){
        Log.info("Index Controller destroy");
    }

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.TEXT_HTML_VALUE})
    public TemplateInstance goIndex(){
        Log.info("Datasource: " + dataSource);
        return indexTempl.instance();
    }
}
