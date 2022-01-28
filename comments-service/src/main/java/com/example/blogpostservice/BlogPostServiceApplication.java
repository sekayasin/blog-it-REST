package com.example.blogpostservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BlogPostServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogPostServiceApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){return new ModelMapper();}

}
