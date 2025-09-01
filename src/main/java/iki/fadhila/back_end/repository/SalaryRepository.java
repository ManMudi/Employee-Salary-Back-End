package iki.fadhila.back_end.repository;

import iki.fadhila.back_end.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary,Long>{
}
