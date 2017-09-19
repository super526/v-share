package com.supan.vshare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@RestController
@MapperScan(basePackages = "com.supan.vshare.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/echo")
    public String hello(){
        return "hello world";
    }
    @GetMapping("/")
    public ModelAndView root() {
        ModelAndView modelAndView = new ModelAndView("/index");
        return modelAndView;
    }
}

