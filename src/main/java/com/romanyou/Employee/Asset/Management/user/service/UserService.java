package com.romanyou.Employee.Asset.Management.user.service;

import com.romanyou.Employee.Asset.Management.user.entity.Role;
import com.romanyou.Employee.Asset.Management.user.entity.AppUser;

import java.util.List;

public interface UserService {

    AppUser saveUser(AppUser appUser);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
