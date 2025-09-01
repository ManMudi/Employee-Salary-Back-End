package iki.fadhila.back_end.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SalaryDto {
    private Long id;
    private String name;
    private double amount;
    private  double allowance;
}
