package com.romanyou.Employee.Asset.Management.user.repository;

import com.romanyou.Employee.Asset.Management.user.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);
}
