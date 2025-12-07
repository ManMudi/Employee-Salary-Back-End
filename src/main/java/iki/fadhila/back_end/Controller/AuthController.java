package iki.fadhila.back_end.Controller;

import iki.fadhila.back_end.dto.JwtResponse;
import iki.fadhila.back_end.dto.LoginDto;
import iki.fadhila.back_end.dto.UserDto;
import iki.fadhila.back_end.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("auth")
@CrossOrigin("*")
public class AuthController {

    private AuthService authService;

    @PostMapping("register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto){
        String registerUser= authService.register(userDto);
        return new ResponseEntity<>(registerUser, HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginDto loginDto){
        JwtResponse jwtResponse=authService.login(loginDto);
        return new ResponseEntity<>(jwtResponse,HttpStatus.OK);
    }
}
