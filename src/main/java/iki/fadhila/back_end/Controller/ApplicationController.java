package iki.fadhila.back_end.Controller;

import iki.fadhila.back_end.dto.ApplicationDto;
import iki.fadhila.back_end.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("applications")
@CrossOrigin("*")
public class ApplicationController {

    private ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<ApplicationDto> createApplication(@RequestBody ApplicationDto applicationDto){
        ApplicationDto applicationDto1=applicationService.createApplication(applicationDto);
        return new ResponseEntity<>(applicationDto1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ApplicationDto>> getAllApplication(){
        List<ApplicationDto> applicationDtoList=applicationService.getAllApplication();
        return ResponseEntity.ok(applicationDtoList);
    }
    @GetMapping("fetch")
    public ResponseEntity<List<ApplicationDto>> listResponseEntity(){
        List<ApplicationDto> application=applicationService.getApplicationByUserId();
        return ResponseEntity.ok(application);
    }

}
