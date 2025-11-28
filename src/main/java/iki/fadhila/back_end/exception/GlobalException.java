package iki.fadhila.back_end.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.rmi.AlreadyBoundException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ErrorEntity> resourceNotFound(WebRequest request,
                                                 ResourceNotFoundException exception,
                                                 LocalDateTime localDateTime){
        ErrorEntity  errorEntity=new ErrorEntity();
        errorEntity.setErrorCode(request.getDescription(false));
        errorEntity.setMessage(exception.getMessage());
        errorEntity.setLocalDateTime(localDateTime);
        return new ResponseEntity<>(errorEntity, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyBoundException.class)
    ResponseEntity<ErrorEntity> alreadyFound(WebRequest request,
                                             EmailUsernameAlreadyFound alreadyFound,
                                             LocalDateTime localDateTime){
        ErrorEntity  errorEntity=new ErrorEntity();
        errorEntity.setErrorCode(request.getDescription(false));
        errorEntity.setMessage(alreadyFound.getMessage());
        errorEntity.setLocalDateTime(localDateTime);
        return new ResponseEntity<>(errorEntity, HttpStatus.NOT_FOUND);
    }
}
