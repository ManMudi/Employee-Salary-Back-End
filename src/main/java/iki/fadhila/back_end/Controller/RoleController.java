package iki.fadhila.back_end.Controller;

import iki.fadhila.back_end.dto.RoleDto;
import iki.fadhila.back_end.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("roles")
@CrossOrigin("*")
public class RoleController {

    private RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto){
        RoleDto roleDto1=roleService.createRole(roleDto);
        return new ResponseEntity<>(roleDto1, HttpStatus.CREATED);
    }
}
