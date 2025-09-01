package iki.fadhila.back_end.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorEntity {
    private LocalDateTime localDateTime;
    private String path;
    private String error;
}
