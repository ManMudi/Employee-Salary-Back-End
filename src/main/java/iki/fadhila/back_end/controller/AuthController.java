package iki.fadhila.back_end.controller;

import iki.fadhila.back_end.dto.UserDto;
import iki.fadhila.back_end.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("auth")
@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private AuthService authService;

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto){
        String string=authService.createUser(userDto);
        return new ResponseEntity<>(string, HttpStatus.CREATED);
    }
}
