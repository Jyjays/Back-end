package com.jyjays;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.jyjays.mapper")
@SpringBootApplication
public class BackEndAssessmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndAssessmentApplication.class, args);
    }

}
