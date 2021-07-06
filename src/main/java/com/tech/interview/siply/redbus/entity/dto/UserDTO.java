package com.tech.interview.siply.redbus.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tech.interview.siply.redbus.constant.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String firstName;
    private String middleName;
    private String lastName;
    private String preferredName;
    private Integer age;
    private Gender gender;
    private String address1;
    private String address2;
    private String country;
    private String city;
    private String pincode;
    private String phoneNo;
    private String emailAddress;
    private Date dateOfBirth;
}
