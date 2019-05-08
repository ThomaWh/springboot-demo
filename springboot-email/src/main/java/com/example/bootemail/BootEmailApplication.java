package com.example.bootemail;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.bootemail.mapper")
public class BootEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootEmailApplication.class, args);
    }

}
