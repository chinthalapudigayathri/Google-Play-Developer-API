package com.gayathri.projects.controller;

import com.gayathri.projects.model.AppDetails;
import com.gayathri.projects.service.GooglePlayScrapperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/apps")
public class ThirdPartyController
{

    // Create object for googleplayscrapper service
    private final GooglePlayScrapperService thirdpartyService;

    public ThirdPartyController(GooglePlayScrapperService thirdpartyService) {
        this.thirdpartyService = thirdpartyService;
    }

    @GetMapping("/details")
    public ResponseEntity<AppDetails> getAppDetails(
            @RequestParam(name = "appID") String appID
    ) throws IOException {
        AppDetails details = thirdpartyService.fetchAppDetails(appID);
        return ResponseEntity.ok(details);
    }

}