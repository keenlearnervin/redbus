package com.tech.interview.siply.redbus.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tech.interview.siply.redbus.constant.Gender;
import com.tech.interview.siply.redbus.constant.Status;
import com.tech.interview.siply.redbus.constant.Type;
import com.tech.interview.siply.redbus.constant.UserType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class RegistrationDTO {
    public String verifyQuestion;
    public String verifyAnswer;
    public Boolean isLocked = Boolean.FALSE;
    public Boolean isEnabled = Boolean.TRUE;
    public Boolean isCredExpired = Boolean.FALSE;
    public Boolean isAccExpired = Boolean.FALSE;
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
    private Status status;
    private Type type;
    private String licenseNo;
    private Integer noOfBuses;
    private String agencyName;
    private UserType userType;
}
