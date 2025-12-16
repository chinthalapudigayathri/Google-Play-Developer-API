package com.gayathri.projects.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppDetails
{
    private String appID;
    private String title;
    private String developer;
    private String rating;
    private String installs;


}