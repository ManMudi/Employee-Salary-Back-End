package iki.fadhila.back_end.service.impl;

import iki.fadhila.back_end.dto.UserDto;
import iki.fadhila.back_end.entity.Role;
import iki.fadhila.back_end.entity.User;
import iki.fadhila.back_end.repository.RoleRepository;
import iki.fadhila.back_end.repository.UserRepository;
import iki.fadhila.back_end.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public String createUser(UserDto userDto) {
        if(userRepository.existsByEmail(userDto.getEmail())){
            throw new RuntimeException(userDto.getEmail()+" Email Already Found !");
        }
        if(userRepository.existsByUsername(userDto.getUsername())){
            throw new RuntimeException(userDto.getEmail()+" Username Already Found !");
        }

        User user=new User();
        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Set<Role> roles=new HashSet<>();
        Role userRole=roleRepository.findByName("ROLE_USER");
        roles.add(userRole);

        user.setRoles(roles);
        userRepository.save(user);
        return "User Registered Successfully !";
    }
}
