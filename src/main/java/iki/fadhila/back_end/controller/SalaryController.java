package iki.fadhila.back_end.controller;

import iki.fadhila.back_end.dto.SalaryDto;
import iki.fadhila.back_end.service.SalaryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("salaries")
@AllArgsConstructor
public class SalaryController {

    private SalaryService salaryService;

    @PostMapping
    public ResponseEntity<SalaryDto> createSalary(@RequestBody SalaryDto salaryDto){
        SalaryDto salaryDto1=salaryService.createSalary(salaryDto);
        return new ResponseEntity<>(salaryDto1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SalaryDto>> listAllSalaries(){
        List<SalaryDto> salaryDto=salaryService.findAllSalaries();
        return ResponseEntity.ok(salaryDto);
    }
    @GetMapping("{id}")
    public ResponseEntity<SalaryDto> getSalaryById(@PathVariable Long id){
        SalaryDto salaryDto=salaryService.findSalaryById(id);
        return ResponseEntity.ok(salaryDto);
    }
    @PutMapping("{id}")
    public ResponseEntity<SalaryDto> updateSalary(@RequestBody SalaryDto salaryDto,@PathVariable Long id){
        SalaryDto salaryDto1=salaryService.updateSalary(salaryDto,id);
        return ResponseEntity.ok(salaryDto1);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSalaryById(@PathVariable Long id){
        salaryService.deleteSalary(id);
        return ResponseEntity.ok("User deleted Successfully ! "+id);
    }
}
