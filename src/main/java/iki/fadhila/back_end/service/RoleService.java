package iki.fadhila.back_end.service;

import iki.fadhila.back_end.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto createRole(RoleDto roleDto);
    List<RoleDto> getAllRoles();
    RoleDto getRoleById(Long id);
    RoleDto updateRole(RoleDto roleDto,Long id);
    String deleteRole(Long id);
}
