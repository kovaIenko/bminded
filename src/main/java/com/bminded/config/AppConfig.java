package com.bminded.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@Configuration
public class AppConfig {

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://sl-eu-lon-2-portal.7.dblayer.com:23257/mydb");
        driverManagerDataSource.setUsername("admin");
        driverManagerDataSource.setPassword("RYWSYSZYKEAGFKAO");
        return driverManagerDataSource;
    }

}
