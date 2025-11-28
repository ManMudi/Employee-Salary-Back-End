package iki.fadhila.back_end.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class EmailUsernameAlreadyFound  extends Exception{
    public EmailUsernameAlreadyFound(String message) {
        super(message);
    }
}
