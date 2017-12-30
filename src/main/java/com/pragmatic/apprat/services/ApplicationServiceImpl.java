package com.pragmatic.apprat.services;

import com.pragmatic.apprat.domain.Application;
import com.pragmatic.apprat.repositories.ApplicationRepository;

import java.util.HashSet;
import java.util.Set;

public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository){
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Set<Application> getApplications() {
        Set<Application> applications = new HashSet<>();
        applications = applicationRepository.findAll();
        return applications;
    }

    @Override
    public Application findById(Long id) {
        return null;
    }
}
