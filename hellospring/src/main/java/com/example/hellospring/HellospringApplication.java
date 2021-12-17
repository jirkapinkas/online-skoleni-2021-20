package com.example.hellospring;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class HellospringApplication {

//    @Bean
//    public DataSource dataSource(@Value("${spring.datasource.url}") String url,
//                                 @Value("${spring.datasource.username}") String username,
//                                 @Value("${spring.datasource.password}") String password) {
//        HikariDataSource ds = new HikariDataSource();
//        ds.setJdbcUrl(url);
//        ds.setUsername(username);
//        ds.setPassword(password);
//        return ds;
//    }

    public static void main(String[] args) {
        SpringApplication.run(HellospringApplication.class, args);
    }

}
