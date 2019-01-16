package com.chan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MallTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallTaskApplication.class, args);
        System.err.println("Hello Task...");
    }

}

