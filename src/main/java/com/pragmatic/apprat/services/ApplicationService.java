package com.pragmatic.apprat.services;

import com.pragmatic.apprat.domain.Application;

import java.util.Set;

public interface ApplicationService {
    Set<Application> getApplications();
    Application findById(Long id);
}
