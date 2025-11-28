package iki.fadhila.back_end.mapper;

import iki.fadhila.back_end.dto.JobDto;
import iki.fadhila.back_end.entity.Job;

public class JobMapper {

    public static Job mapToJob(JobDto jobDto){
        Job job=new Job();
        job.setId(jobDto.getId());
        job.setDepartment(jobDto.getDepartment());
        job.setTittle(jobDto.getTittle());
        job.setSalary(jobDto.getSalary());
        job.setLocation(jobDto.getLocation());
        return job;
    }

    public static JobDto mapToJobDto(Job job){
        JobDto jobDto=new JobDto();
        jobDto.setId(job.getId());
        jobDto.setDepartment(job.getDepartment());
        jobDto.setSalary(job.getSalary());
        jobDto.setTittle(job.getTittle());
        jobDto.setLocation(job.getLocation());
        return jobDto;
    }
}
