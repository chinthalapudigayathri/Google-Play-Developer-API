package com.gayathri.projects.controller;

import com.gayathri.projects.service.GooglePlayAPIService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/playstore")
public class GooglePlayController
{
    private final GooglePlayAPIService service;

    /* This is a constructor, method name same as class. No return type. Gets called everytime an object is created */
    public GooglePlayController(GooglePlayAPIService service) {
        this.service = service;
    }

    /* Getting app and access token and making rest call through controller */

    @GetMapping("/reviews")
    public ResponseEntity<String> getReviews(
            @RequestParam String packageName,
            @RequestHeader("Authorization") String authorization
    ) {
        // Extract token from "Bearer <token>"
        String accessToken = authorization.replace("Bearer ", "");
        return ResponseEntity.ok(
                service.fetchReviews(packageName, accessToken)
        );
    }
}
