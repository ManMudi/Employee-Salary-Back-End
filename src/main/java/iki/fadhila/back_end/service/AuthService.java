package iki.fadhila.back_end.service;

import iki.fadhila.back_end.dto.LoginDto;
import iki.fadhila.back_end.dto.UserDto;
import iki.fadhila.back_end.entity.User;

public interface AuthService {
    String register(UserDto userDto);
    String login(LoginDto loginDto);
}
