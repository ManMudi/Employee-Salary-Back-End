package iki.fadhila.back_end.service.impl;

import iki.fadhila.back_end.dto.UserDto;
import iki.fadhila.back_end.entity.User;
import iki.fadhila.back_end.mapper.UserMapper;
import iki.fadhila.back_end.repository.UserRepository;
import iki.fadhila.back_end.security.JwtUtilsProvider;
import iki.fadhila.back_end.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private JwtUtilsProvider jwtUtilsProvider;

    @Override
    public User profile() {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String usernameOrEmail=authentication.getName();
        return userRepository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail).orElseThrow(
                () -> new RuntimeException("Not Found !")
        );
    }
}
