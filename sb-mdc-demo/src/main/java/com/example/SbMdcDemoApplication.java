package com.example;

import com.example.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfig.class)
public class SbMdcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbMdcDemoApplication.class, args);
    }

}
