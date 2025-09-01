package iki.fadhila.back_end.service;

import iki.fadhila.back_end.dto.SalaryDto;

import java.util.List;

public interface SalaryService {
    SalaryDto createSalary(SalaryDto salaryDto);
    List<SalaryDto> findAllSalaries();
    SalaryDto findSalaryById(Long id);
    SalaryDto updateSalary(SalaryDto salaryDto,Long id);
    void deleteSalary(Long id);
}
