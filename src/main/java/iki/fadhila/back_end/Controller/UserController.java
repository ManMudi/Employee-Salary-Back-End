package iki.fadhila.back_end.Controller;

import iki.fadhila.back_end.dto.UserDto;
import iki.fadhila.back_end.entity.User;
import iki.fadhila.back_end.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("users")
@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class UserController {

    private UserService userService;

    @GetMapping("profile")
    public ResponseEntity<User> getProfile(){
        User userDto=userService.profile();
        return ResponseEntity.ok(userDto);
    }
}
