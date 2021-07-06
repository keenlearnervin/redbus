package com.tech.interview.siply.redbus.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tech.interview.siply.redbus.constant.Gender;
import com.tech.interview.siply.redbus.constant.Status;
import com.tech.interview.siply.redbus.constant.Type;
import com.tech.interview.siply.redbus.constant.UserType;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class RegistrationDTO {
    private String firstName;
    private String middleName;
    private String lastName;
    private String preferredName;
    private int age;
    private Gender gender;
    private String address1;
    private String address2;
    private String country;
    private String city;
    private String pincode;
    private String phoneNo;
    private String emailAddress;
    private Date dateOfBirth;

    private Status status;
    private Type type;
    private String licenseNo;
    private Integer noOfBuses;
    private String agencyName;

    @Enumerated(EnumType.STRING)
    private UserType userType;
}
