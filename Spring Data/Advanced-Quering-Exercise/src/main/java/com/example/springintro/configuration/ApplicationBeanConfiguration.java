package com.example.springintro.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Scanner scanner () {
        // singleton instance
        // can inject
        return new Scanner(System.in);
    }

}
