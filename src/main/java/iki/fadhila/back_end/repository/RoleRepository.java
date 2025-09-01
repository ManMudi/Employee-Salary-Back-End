package iki.fadhila.back_end.repository;

import iki.fadhila.back_end.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Boolean existsByName(String name);
    Role findByName(String name);
}
