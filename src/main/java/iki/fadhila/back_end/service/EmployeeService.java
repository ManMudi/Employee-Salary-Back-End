package iki.fadhila.back_end.service;

import iki.fadhila.back_end.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createUser(EmployeeDto employeeDto);
    List<EmployeeDto> findAllUsers();
    EmployeeDto updateUser(EmployeeDto employeeDto, Long id);
    EmployeeDto findUserById(Long id);
    void deleteUser(Long id);
}
