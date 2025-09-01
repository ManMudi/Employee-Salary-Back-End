package iki.fadhila.back_end.repository;

import iki.fadhila.back_end.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
   Boolean existsByUsername(String username);
   Boolean existsByEmail(String email);
}
