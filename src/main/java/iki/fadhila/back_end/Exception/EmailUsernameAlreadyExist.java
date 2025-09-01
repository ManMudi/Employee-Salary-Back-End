package iki.fadhila.back_end.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailUsernameAlreadyExist  extends RuntimeException{
    public EmailUsernameAlreadyExist(String message) {
        super(message);
    }
}
