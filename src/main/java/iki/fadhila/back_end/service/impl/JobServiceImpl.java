package iki.fadhila.back_end.service.impl;

import iki.fadhila.back_end.dto.JobDto;
import iki.fadhila.back_end.entity.Job;
import iki.fadhila.back_end.mapper.JobMapper;
import iki.fadhila.back_end.repository.JobRepository;
import iki.fadhila.back_end.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    @Override
    public JobDto createJob(JobDto jobDto) {
        Job job= JobMapper.mapToJob(jobDto);
        Job job1=jobRepository.save(job);
        return JobMapper.mapToJobDto(job1);
    }

    @Override
    public List<JobDto> getAllJobs() {
        List<Job> jobs=jobRepository.getAllJobs();
        return jobs.stream().map(JobMapper::mapToJobDto).collect(Collectors.toList());
    }
}
