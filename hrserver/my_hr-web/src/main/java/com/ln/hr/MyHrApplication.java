package com.ln.hr;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ln.hr.mapper")
public class MyHrApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyHrApplication.class, args);
    }

}
