package iki.fadhila.back_end.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ErrorEntity> responseEntity(ResourceNotFoundException exception, WebRequest webRequest){
        ErrorEntity errorEntity=new ErrorEntity();
        errorEntity.setLocalDateTime(LocalDateTime.now());
        errorEntity.setPath(webRequest.getDescription(false));
        errorEntity.setError(exception.getMessage());
        return new ResponseEntity<>(errorEntity, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailUsernameAlreadyExist.class)
    ResponseEntity<ErrorEntity> responseEntity(EmailUsernameAlreadyExist alreadyExist,WebRequest webRequest){
        ErrorEntity errorEntity=new ErrorEntity();
        errorEntity.setPath(webRequest.getDescription(false));
        errorEntity.setLocalDateTime(LocalDateTime.now());
        errorEntity.setError(alreadyExist.getMessage());
        return new ResponseEntity<>(errorEntity,HttpStatus.BAD_REQUEST);
    }
}
