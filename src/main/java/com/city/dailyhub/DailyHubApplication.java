package com.city.dailyhub;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.city.dailyhub.dao.mapper")
public class DailyHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailyHubApplication.class, args);
    }

}
