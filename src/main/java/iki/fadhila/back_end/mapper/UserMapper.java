package iki.fadhila.back_end.mapper;

import iki.fadhila.back_end.dto.UserDto;
import iki.fadhila.back_end.entity.User;

public class UserMapper {

    public static User mapToUser(UserDto userDto){
        User user=new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public static UserDto maptoUserDto(User user){
        UserDto userDto=new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setId(user.getId());
        return userDto;
    }
}
