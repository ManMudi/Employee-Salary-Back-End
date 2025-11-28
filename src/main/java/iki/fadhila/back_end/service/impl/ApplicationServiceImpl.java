package iki.fadhila.back_end.service.impl;

import iki.fadhila.back_end.dto.ApplicationDto;
import iki.fadhila.back_end.entity.Application;
import iki.fadhila.back_end.entity.Job;
import iki.fadhila.back_end.entity.User;
import iki.fadhila.back_end.mapper.ApplicationMapper;
import iki.fadhila.back_end.repository.ApplicationRepository;
import iki.fadhila.back_end.repository.JobRepository;
import iki.fadhila.back_end.repository.UserRepository;
import iki.fadhila.back_end.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationRepository applicationRepository;
    private JobRepository jobRepository;
    private UserRepository userRepository;

    @Override
    public ApplicationDto createApplication(ApplicationDto applicationDto) {
        Application application= ApplicationMapper.mapToApplication(applicationDto);
        Job job=jobRepository.findById(applicationDto.getJobId()).orElseThrow(
                () -> new RuntimeException("Not Found !"));
        User user =userRepository.findById(applicationDto.getUserId()).orElseThrow(
                () -> new RuntimeException("Not Found !"));
        application.setUser(user);
        application.setJob(job);
        Application application1=applicationRepository.save(application);
        return ApplicationMapper.mapToApplicationDto(application1);
    }

    @Override
    public List<ApplicationDto> getAllApplication() {
        List<Application> applications=applicationRepository.findAll();
        return applications.stream().map(ApplicationMapper::mapToApplicationDto).collect(Collectors.toList());
    }

    @Override
    public List<ApplicationDto> getApplicationByUserId() {
        List<Application> applications=applicationRepository.findByUserId(1L);
        return applications.stream().map(ApplicationMapper::mapToApplicationDto).collect(Collectors.toList());
    }
}
