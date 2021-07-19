package com.tech.interview.siply.redbus.entity.dao.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tech.interview.siply.redbus.constant.Gender;
import com.tech.interview.siply.redbus.constant.UserType;
import com.tech.interview.siply.redbus.entity.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "tbl_users")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@OnDelete(action = OnDeleteAction.CASCADE)
public class User implements Serializable {
    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    public UUID id = UUID.randomUUID();

    @Column(name = "first_name")
    public String firstName;
    @Column(name = "middle_name")
    public String middleName;
    @Column(name = "last_name")
    public String lastName;
    @Column(name = "preferred_name")
    public String preferredName;
    @Column(name = "age")
    public Integer age;
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    public Gender gender;
    @Column(name = "address_1")
    public String address1;
    @Column(name = "address_2")
    public String address2;
    @Column(name = "country")
    public String country;
    @Column(name = "city")
    public String city;
    @Column(name = "pincode")
    public String pincode;
    @Column(name = "phone_no")
    public String phoneNo;
    @Column(name = "email_addr")
    public String emailAddress;
    @Column(name = "dob")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    public Date dateOfBirth;
    @Column(name = "user_name")
    public String userName;
    @Column(name = "password")
    public String password;
    @Column(name = "verify_question")
    public String verifyQuestion;
    @Column(name = "verify_answer")
    public String verifyAnswer;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    public UserType userType;

    @Column(name = "created_at", nullable = true, updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedAt;

    @Column(name = "notification_id")
    public UUID notificationId;


    @Column(name = "locked")
    public Boolean isLocked = Boolean.FALSE;

    @Column(name = "enabled")
    public Boolean isEnabled = Boolean.TRUE;

    @Column(name = "credential_expired")
    public Boolean isCredExpired = Boolean.FALSE;

    @Column(name = "account_expired")
    public Boolean isAccExpired = Boolean.FALSE;

    public User(UserDTO userDTO) {
        this.address1 = userDTO.getAddress1();
        this.age = userDTO.getAge();
        this.country = userDTO.getCountry();
        this.address2 = userDTO.getAddress2();
        this.city = userDTO.getCity();
        this.emailAddress = userDTO.getEmailAddress();
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.middleName = userDTO.getMiddleName();
        this.gender = userDTO.getGender();
        this.phoneNo = userDTO.getPhoneNo();
        this.preferredName = userDTO.getPreferredName();
        this.dateOfBirth = userDTO.getDateOfBirth();
        this.pincode = userDTO.getPincode();
        this.userName = userDTO.getUserName();
        this.password = userDTO.getPassword();
        this.verifyQuestion = userDTO.getVerifyQuestion();
        this.verifyAnswer = userDTO.getVerifyAnswer();
        this.userType = userDTO.getUserType();
    }
}
