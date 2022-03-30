package org.harryng.demo.quarkusspring.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

//    db.driver=org.h2.Driver
    @ConfigProperty(name = "db.driver", defaultValue = "")
    private String dbDriver;
//    db.url=jdbc:h2:tcp://localhost/./test_db
    @ConfigProperty(name="db.url", defaultValue = "")
    private String dbUrl;
//    db.username=sa
    @ConfigProperty(name="db.username", defaultValue = "")
    private String dbUsername;
//    db.password=123456
    @ConfigProperty(name="db.password", defaultValue = "")
    private String dbPassword;
//    db.minPoolSize=1
    @ConfigProperty(name="db.minPoolSize", defaultValue = "")
    private int dbMinPoolSize;
//    db.maxPoolSize=5
    @ConfigProperty(name="db.maxPoolSize", defaultValue = "")
    private int dbMaxPoolSize;

    @Bean(destroyMethod = "close")
    public DataSource getDatasource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(dbDriver);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        dataSource.setInitialSize(dbMinPoolSize);
        dataSource.setMaxTotal(dbMaxPoolSize);
        return dataSource;
    }
}
