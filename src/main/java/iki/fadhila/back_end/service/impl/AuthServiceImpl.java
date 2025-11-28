package iki.fadhila.back_end.service.impl;

import iki.fadhila.back_end.dto.LoginDto;
import iki.fadhila.back_end.dto.UserDto;
import iki.fadhila.back_end.entity.Role;
import iki.fadhila.back_end.entity.User;
import iki.fadhila.back_end.repository.RoleRepository;
import iki.fadhila.back_end.repository.UserRepository;
import iki.fadhila.back_end.security.JwtUtilsProvider;
import iki.fadhila.back_end.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private PasswordEncoder  passwordEncoder;
    private RoleRepository roleRepository;
    private AuthenticationManager authenticationManager;
    private JwtUtilsProvider jwtUtilsProvider;

    @Override
    public String register(UserDto userDto) {
        User user=new User();
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        Role role=roleRepository.findByName("ROLE_APPLICANT");

        Set<Role> roles=new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
        return "Saved Successfully !";
    }

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(),
                loginDto.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtUtilsProvider.generateToken(authentication);
    }
}
