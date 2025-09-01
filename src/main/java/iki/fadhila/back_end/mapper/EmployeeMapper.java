package iki.fadhila.back_end.mapper;

import iki.fadhila.back_end.dto.EmployeeDto;
import iki.fadhila.back_end.entity.Employee;

public class EmployeeMapper {

    public static Employee mapToUser(EmployeeDto employeeDto){
        Employee employee =new Employee();
        employee.setId(employeeDto.getId());
        employee.setUsername(employeeDto.getUsername());
        employee.setEmail(employeeDto.getEmail());
        return employee;
    }

    public static EmployeeDto mapToUserDto(Employee employee){
        EmployeeDto employeeDto =new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setUsername(employee.getUsername());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setSalaryId(employee.getSalary().getId());
        return employeeDto;
    }
}
