package com.crm.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //The special class that automatically executed when the project is started(run), and the information presnt inside config class is given to springboot.
public class configClass {
    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }
}
