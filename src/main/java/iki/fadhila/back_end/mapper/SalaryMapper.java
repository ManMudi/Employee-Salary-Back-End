package iki.fadhila.back_end.mapper;

import iki.fadhila.back_end.dto.SalaryDto;
import iki.fadhila.back_end.entity.Salary;

public class SalaryMapper {

    public static Salary mapToSalary(SalaryDto salaryDto){
        Salary salary=new Salary();
        salary.setId(salaryDto.getId());
        salary.setName(salaryDto.getName());
        salary.setAmount(salaryDto.getAmount());
        salary.setAllowance(salaryDto.getAllowance());
        return salary;
    }

    public static SalaryDto mapToSalaryDto(Salary salary){
        SalaryDto salaryDto=new SalaryDto();
        salaryDto.setId(salary.getId());
        salaryDto.setName(salary.getName());
        salaryDto.setAmount(salary.getAmount());
        salaryDto.setAllowance(salary.getAllowance());
        return salaryDto;
    }
}
