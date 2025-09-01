package iki.fadhila.back_end.service.impl;

import iki.fadhila.back_end.Exception.ResourceNotFoundException;
import iki.fadhila.back_end.dto.SalaryDto;
import iki.fadhila.back_end.entity.Salary;
import iki.fadhila.back_end.mapper.SalaryMapper;
import iki.fadhila.back_end.repository.SalaryRepository;
import iki.fadhila.back_end.service.SalaryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SalaryServiceImpl implements SalaryService {

    private SalaryRepository salaryRepository;

    @Override
    public SalaryDto createSalary(SalaryDto salaryDto) {
        Salary salary= SalaryMapper.mapToSalary(salaryDto);
        Salary salary1=salaryRepository.save(salary);
        return SalaryMapper.mapToSalaryDto(salary1);
    }

    @Override
    public List<SalaryDto> findAllSalaries() {
        List<Salary> salaries=salaryRepository.findAll();
        return salaries.stream().map(SalaryMapper::mapToSalaryDto).collect(Collectors.toList());
    }

    @Override
    public SalaryDto findSalaryById(Long id) {
        Salary  salary=salaryRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Salary of that Id Not Found "+id));
        return SalaryMapper.mapToSalaryDto(salary);
    }

    @Override
    public SalaryDto updateSalary(SalaryDto salaryDto, Long id) {
        Salary  salary=salaryRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Salary of that Id Not Found "+id));
        salary.setName(salaryDto.getName());
        salary.setAmount(salaryDto.getAmount());
        salary.setAllowance(salaryDto.getAllowance());
        Salary salary1=salaryRepository.save(salary);
        return SalaryMapper.mapToSalaryDto(salary1);
    }

    @Override
    public void deleteSalary(Long id) {
        Salary  salary=salaryRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Salary of that Id Not Found "+id));
        salaryRepository.deleteById(id);
    }
}
