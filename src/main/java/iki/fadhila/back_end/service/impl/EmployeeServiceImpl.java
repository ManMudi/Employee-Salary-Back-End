package iki.fadhila.back_end.service.impl;

import iki.fadhila.back_end.Exception.EmailUsernameAlreadyExist;
import iki.fadhila.back_end.Exception.ResourceNotFoundException;
import iki.fadhila.back_end.dto.EmployeeDto;
import iki.fadhila.back_end.entity.Employee;
import iki.fadhila.back_end.entity.Salary;
import iki.fadhila.back_end.mapper.EmployeeMapper;
import iki.fadhila.back_end.repository.SalaryRepository;
import iki.fadhila.back_end.repository.EmployeeRepository;
import iki.fadhila.back_end.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private SalaryRepository salaryRepository;

    @Override
    public EmployeeDto createUser(EmployeeDto employeeDto) {
        if(employeeRepository.existsByUsername(employeeDto.getUsername())){
            throw new EmailUsernameAlreadyExist("Username Already Exist ! "+ employeeDto.getUsername());
        }

        if(employeeRepository.existsByEmail(employeeDto.getEmail())){
            throw new EmailUsernameAlreadyExist("Email Already Exist ! "+ employeeDto.getEmail());
        }
        Salary salary=salaryRepository.findById(employeeDto.getSalaryId()).orElseThrow(() ->
                new ResourceNotFoundException("Salary of that Id not Found "+ employeeDto.getSalaryId()));
        Employee employee = EmployeeMapper.mapToUser(employeeDto);
        employee.setSalary(salary);
        Employee employee1 = employeeRepository.save(employee);
        return EmployeeMapper.mapToUserDto(employee1);
    }

    @Override
    public List<EmployeeDto> findAllUsers() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateUser(EmployeeDto employeeDto, Long id) {

        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User of that ID not Found "+id));
        Salary salary=salaryRepository.findById(employeeDto.getSalaryId()).orElseThrow(() ->
                new ResourceNotFoundException("Salary of that Id not Found "+ employeeDto.getSalaryId()));
        employee.setEmail(employeeDto.getEmail());
        employee.setUsername(employeeDto.getUsername());
        employee.setSalary(salary);
        Employee employee1 = employeeRepository.save(employee);
        return EmployeeMapper.mapToUserDto(employee1);
    }

    @Override
    public EmployeeDto findUserById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User of that ID not Found "+id));
        return EmployeeMapper.mapToUserDto(employee);
    }

    @Override
    public void deleteUser(Long id) {
        employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User of that ID not Found "+id));
        employeeRepository.deleteById(id);
    }
}
