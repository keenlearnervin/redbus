package com.tech.interview.siply.redbus.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tech.interview.siply.redbus.constant.Gender;
import com.tech.interview.siply.redbus.constant.UserType;
import lombok.*;

import javax.persistence.Column;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    public String userName;
    public String password;
    public String verifyQuestion;
    public String verifyAnswer;
    public UserType userType;
    public Boolean isLocked;
    public Boolean isEnabled;
    public Boolean isCredExpired;
    public Boolean isAccExpired;
}
