package com.example.authenticationauthorizationservice.controllers;

import com.example.authenticationauthorizationservice.domain.AppUser;
import com.example.authenticationauthorizationservice.domain.Role;
import com.example.authenticationauthorizationservice.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers(){
        return ResponseEntity.ok().body(userService.getAppUsers());
    }

    @PostMapping("/users/register")
    public ResponseEntity<AppUser> registerUser(@RequestBody AppUser appUser){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/users/register").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(appUser));
    }

    @PostMapping("/users/role/register")
    public ResponseEntity<Role> registerUser(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/users/role/register").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/users/role/addtouser")
    public ResponseEntity<?> registerUser(@RequestBody RoleToUserForm roleToUserForm){
        userService.addRoleToUser(roleToUserForm.getUsername(),roleToUserForm.getRoleName());
        return ResponseEntity.ok().build();
    }

}
@Data
class RoleToUserForm{
    private String username;
    private String roleName;
}
