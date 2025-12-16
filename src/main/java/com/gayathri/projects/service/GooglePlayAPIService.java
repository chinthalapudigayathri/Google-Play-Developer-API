package com.gayathri.projects.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/* Directly calling google api from this service*/

@Service
public class GooglePlayAPIService
{

    //Base end point of google play developer api - android publisher api v3
    private static final String BASE_URL = "https://androidpublisher.googleapis.com/androidpublisher/v3/applications";
    //Creating Spring Rest Template Object
    private final RestTemplate restTemplate = new RestTemplate();

    public String fetchReviews(String packageName, String accessToken) {

        /* This is constructing full url which is base api declared in  class level + app name + reviews
        * This will directky takes us to reviews page of app
         */
        String url = BASE_URL + "/" + packageName + "/reviews";
        // Create an Empty header object
        HttpHeaders headers = new HttpHeaders();
        //Create Authorization in headers
        headers.setBearerAuth(accessToken);
        //Set content type for rest call
        headers.setContentType(MediaType.APPLICATION_JSON);
        // Wrap header into HTTP entity
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        // Making http call
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );

        // Returning Raw json data
        return response.getBody();

    }
}