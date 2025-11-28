package iki.fadhila.back_end.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDto {
    private Long id;
    private int score;
    private String resume;
    private Long jobId;
    private Long userId;
}
