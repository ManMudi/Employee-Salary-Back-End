package iki.fadhila.back_end.controller;

import iki.fadhila.back_end.dto.EmployeeDto;
import iki.fadhila.back_end.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
@AllArgsConstructor
@CrossOrigin("*")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createUser(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = employeeService.createUser(employeeDto);
        return new ResponseEntity<>(employeeDto1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> listAllUsers(){
        List<EmployeeDto> employeeDto = employeeService.findAllUsers();
        return ResponseEntity.ok(employeeDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateUser(@RequestBody EmployeeDto employeeDto, @PathVariable Long id){
        EmployeeDto employeeDto1 = employeeService.updateUser(employeeDto,id);
        return ResponseEntity.ok(employeeDto1);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> findUserById(@PathVariable Long id){
        EmployeeDto employeeDto = employeeService.findUserById(id);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        employeeService.deleteUser(id);
        return ResponseEntity.ok(id +" Deleted Successfully !");
    }
}
