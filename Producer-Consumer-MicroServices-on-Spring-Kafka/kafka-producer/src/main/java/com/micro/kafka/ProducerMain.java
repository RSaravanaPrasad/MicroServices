package com.micro.kafka;

import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.annotation.ComponentScan;
@ComponentScan({"com.micro.kafka.config", "com.micro.kafka.controller"})
@SpringBootApplication
public class ProducerMain {
    public static void main(String[] args) {
        SpringApplication.run(ProducerMain.class, args);
    }

}

