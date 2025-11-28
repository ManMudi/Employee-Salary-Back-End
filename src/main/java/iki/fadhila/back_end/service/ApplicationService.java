package iki.fadhila.back_end.service;

import iki.fadhila.back_end.dto.ApplicationDto;

import java.util.List;

public interface ApplicationService {
    ApplicationDto createApplication(ApplicationDto applicationDto);
    List<ApplicationDto> getAllApplication();
    List<ApplicationDto> getApplicationByUserId();
}
