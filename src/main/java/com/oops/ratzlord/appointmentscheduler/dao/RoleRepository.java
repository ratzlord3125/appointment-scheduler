package com.oops.ratzlord.appointmentscheduler.dao;

import com.oops.ratzlord.appointmentscheduler.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String roleName);
}
