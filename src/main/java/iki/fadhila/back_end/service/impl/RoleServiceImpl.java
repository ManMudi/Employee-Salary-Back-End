package iki.fadhila.back_end.service.impl;

import iki.fadhila.back_end.Exception.ResourceNotFoundException;
import iki.fadhila.back_end.dto.RoleDto;
import iki.fadhila.back_end.entity.Role;
import iki.fadhila.back_end.mapper.RoleMapper;
import iki.fadhila.back_end.repository.RoleRepository;
import iki.fadhila.back_end.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        Role role=RoleMapper.mapToRole(roleDto);
        Role role1=roleRepository.save(role);
        return RoleMapper.mapToRoleDto(role1);
    }

    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> roles=roleRepository.findAll();
        return roles.stream().map(RoleMapper::mapToRoleDto).collect(Collectors.toList());
    }

    @Override
    public RoleDto getRoleById(Long id) {
        Role role=roleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Role of that Id Not Found "+id));
        return RoleMapper.mapToRoleDto(role);
    }

    @Override
    public RoleDto updateRole(RoleDto roleDto, Long id) {
        Role role=roleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Role of that Id Not Found "+id));
        role.setName((roleDto.getName()));
        Role role1=roleRepository.save(role);
        return RoleMapper.mapToRoleDto(role1);
    }

    @Override
    public String deleteRole(Long id) {
        Role role=roleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Role of that Id Not Found "+id));
        roleRepository.delete(role);
        return "User of Id "+id+" Deleted Successfully !";
    }
}
