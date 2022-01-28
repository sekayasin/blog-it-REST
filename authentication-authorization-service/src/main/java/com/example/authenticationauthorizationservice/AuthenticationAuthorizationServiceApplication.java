package com.example.authenticationauthorizationservice;

import com.example.authenticationauthorizationservice.domain.AppUser;
import com.example.authenticationauthorizationservice.domain.Role;
import com.example.authenticationauthorizationservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class AuthenticationAuthorizationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationAuthorizationServiceApplication.class, args);
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

@Bean
    CommandLineRunner runner(UserService userService){
        return  args -> {
            userService.saveRole(new Role(null,"ROLE_USER"));
            userService.saveRole(new Role(null,"ROLE_MANAGER"));
            userService.saveRole(new Role(null,"ROLE_ADMIN"));
            userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));


            userService.saveUser(new AppUser(null,"Josh Nick","123","joshN","josh@gmail.com",new ArrayList<>()));
            userService.saveUser(new AppUser(null,"Lawrence Nick","123","lawrenceNick","lawrenceNickN@gmail.com",new ArrayList<>()));
            userService.saveUser(new AppUser(null,"Ivan Mugi","123","ivanMugi","ivanMugi@gmail.com",new ArrayList<>()));
            userService.saveUser(new AppUser(null,"Anold Josh","123","anoldJ","anoldJ@gmail.com",new ArrayList<>()));

            userService.addRoleToUser("joshN","ROLE_USER");

            userService.addRoleToUser("lawrenceNick","ROLE_USER");
            userService.addRoleToUser("lawrenceNick","ROLE_MANAGER");
            userService.addRoleToUser("lawrenceNick","ROLE_ADMIN");

            userService.addRoleToUser("ivanMugi","ROLE_USER");
            userService.addRoleToUser("ivanMugi","ROLE_MANAGER");
            userService.addRoleToUser("ivanMugi","ROLE_ADMIN");
            userService.addRoleToUser("ivanMugi","ROLE_SUPER_ADMIN");

            userService.addRoleToUser("anoldJ","ROLE_USER");
            userService.addRoleToUser("anoldJ","ROLE_MANAGER");
        };
    }

}
