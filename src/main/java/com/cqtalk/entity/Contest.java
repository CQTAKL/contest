package com.cqtalk.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contest implements Serializable {
    private Integer id;
    private String contestName;
    private String abbreviation;


    private String levelName;

    private String collegeName;

    private String otherInformation;
    private String detailInformation;
    private String commentLink;


    private String createdUser;
    private String state;
}

