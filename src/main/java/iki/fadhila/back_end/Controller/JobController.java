package iki.fadhila.back_end.Controller;

import iki.fadhila.back_end.dto.JobDto;
import iki.fadhila.back_end.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("jobs")
public class JobController {

    private JobService jobService;

    @PostMapping
    public ResponseEntity<JobDto> createJob(@RequestBody JobDto jobDto){
        JobDto jobDto1=jobService.createJob(jobDto);
        return new ResponseEntity<>(jobDto1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JobDto>> getAllJobs(){
        List<JobDto> job=jobService.getAllJobs();
        return ResponseEntity.ok(job);
    }
}
