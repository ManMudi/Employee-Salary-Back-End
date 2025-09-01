package iki.fadhila.back_end.mapper;

import iki.fadhila.back_end.dto.RoleDto;
import iki.fadhila.back_end.entity.Role;

public class RoleMapper {

    public static Role mapToRole(RoleDto roleDto){
        Role role=new Role();
        role.setId(roleDto.getId());
        role.setName(roleDto.getName());
        return role;
    }

    public static RoleDto mapToRoleDto(Role role){
        RoleDto roleDto=new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        return roleDto;
    }
}
