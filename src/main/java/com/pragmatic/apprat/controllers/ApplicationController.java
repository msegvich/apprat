package com.pragmatic.apprat.controllers;

import com.pragmatic.apprat.services.ApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }

    @RequestMapping("/applications")
    public String getApplications(Model model){
        model.addAttribute("applications", applicationService.getApplications());
        return "applications/index";
    }
}
