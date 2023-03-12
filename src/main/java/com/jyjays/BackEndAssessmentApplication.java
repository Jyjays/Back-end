package com.jyjays;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.validation.annotation.Validated;

@EnableAspectJAutoProxy
@MapperScan("com.jyjays.mapper")
@ServletComponentScan("com.jyjays.filter")
@SpringBootApplication
@Validated
public class BackEndAssessmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndAssessmentApplication.class, args);
    }

}
