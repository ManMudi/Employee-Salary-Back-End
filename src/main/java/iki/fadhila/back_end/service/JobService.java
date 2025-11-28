package iki.fadhila.back_end.service;

import iki.fadhila.back_end.dto.JobDto;

import java.util.List;

public interface JobService {
    JobDto createJob(JobDto jobDto);
    List<JobDto> getAllJobs();
}
