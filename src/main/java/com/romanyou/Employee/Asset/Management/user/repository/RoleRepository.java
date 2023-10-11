package com.romanyou.Employee.Asset.Management.user.repository;

import com.romanyou.Employee.Asset.Management.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
