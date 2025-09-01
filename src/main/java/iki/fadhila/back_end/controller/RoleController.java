package iki.fadhila.back_end.controller;

import iki.fadhila.back_end.dto.RoleDto;
import iki.fadhila.back_end.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("roles")
@AllArgsConstructor
@CrossOrigin("*")
public class RoleController {

    private RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto){
        RoleDto roleDto1=roleService.createRole(roleDto);
        return new ResponseEntity<>(roleDto1, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<RoleDto>> getAllRoles(){
        List<RoleDto> roleDtoList=roleService.getAllRoles();
        return ResponseEntity.ok(roleDtoList);
    }

    @GetMapping("{id}")
    public ResponseEntity<RoleDto> findRoleById(@PathVariable Long id){
        RoleDto roleDto=roleService.getRoleById(id);
        return ResponseEntity.ok(roleDto);
    }
    @PutMapping("{id}")
    public ResponseEntity<RoleDto> updateRole(@RequestBody RoleDto roleDto,@PathVariable Long id){
        RoleDto roleDto1=roleService.updateRole(roleDto,id);
        return ResponseEntity.ok(roleDto1);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
        return ResponseEntity.ok("Role Deleted Successfully !");
    }
}
