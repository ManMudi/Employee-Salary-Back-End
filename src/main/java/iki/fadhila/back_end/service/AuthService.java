package iki.fadhila.back_end.service;

import iki.fadhila.back_end.dto.UserDto;

public interface AuthService {
    String createUser(UserDto userDto);
}
