package com.tech.interview.siply.redbus.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tech.interview.siply.redbus.constant.Gender;
import com.tech.interview.siply.redbus.constant.Status;
import com.tech.interview.siply.redbus.constant.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DriverDTO {
    public String verifyQuestion;
    public String verifyAnswer;
    public UserType userType;
    public Boolean isLocked;
    public Boolean isEnabled;
    public Boolean isCredExpired;
    public Boolean isAccExpired;
    private Status status;
    private String licenseNo;
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
    private String userName;
    private String password;
}
