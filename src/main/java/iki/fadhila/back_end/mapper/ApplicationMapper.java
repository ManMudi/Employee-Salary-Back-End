package iki.fadhila.back_end.mapper;

import iki.fadhila.back_end.dto.ApplicationDto;
import iki.fadhila.back_end.entity.Application;

public class ApplicationMapper {

    public static Application mapToApplication(ApplicationDto applicationDto){
        Application application=new Application();
        application.setId(applicationDto.getId());
        application.setResume(applicationDto.getResume());
        application.setScore(applicationDto.getScore());
        return application;
    }

    public static ApplicationDto mapToApplicationDto(Application application){
        ApplicationDto applicationDto=new ApplicationDto();
        applicationDto.setId(application.getId());
        applicationDto.setScore(application.getScore());
        applicationDto.setResume(application.getResume());
        applicationDto.setUserId(application.getUser().getId());
        applicationDto.setJobId(application.getJob().getId());
        return applicationDto;
    }
}
