package iki.fadhila.back_end.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
    private Long id;
    private String tittle;
    private String department;
    private BigDecimal salary;
    private String location;
}
