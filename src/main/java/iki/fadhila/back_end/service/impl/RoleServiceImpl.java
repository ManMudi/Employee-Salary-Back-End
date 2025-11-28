package iki.fadhila.back_end.service.impl;

import iki.fadhila.back_end.dto.RoleDto;
import iki.fadhila.back_end.entity.Role;
import iki.fadhila.back_end.exception.EmailUsernameAlreadyFound;
import iki.fadhila.back_end.mapper.RoleMapper;
import iki.fadhila.back_end.repository.RoleRepository;
import iki.fadhila.back_end.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Override
    public RoleDto createRole(RoleDto roleDto) {

        if(roleRepository.existsByName(roleDto.getName())){
            throw new RuntimeException("Already Found !");
        }

        Role role= RoleMapper.mapToRole(roleDto);
        Role role1=roleRepository.save(role);
        return RoleMapper.mapToRoleDto(role1);
    }
}
