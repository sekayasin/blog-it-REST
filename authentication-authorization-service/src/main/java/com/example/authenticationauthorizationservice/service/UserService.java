package com.example.authenticationauthorizationservice.service;

import com.example.authenticationauthorizationservice.domain.AppUser;
import com.example.authenticationauthorizationservice.domain.Role;
import com.example.authenticationauthorizationservice.domain.RoleToUserForm;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser appUser);
    Role saveRole(Role role);
    RoleToUserForm addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getAppUsers();
}
