package iki.fadhila.back_end.exception;

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
    private String message;
    private String errorCode;
    private LocalDateTime localDateTime;
}
