package com.tech.interview.siply.redbus.entity.dao.users;

import com.tech.interview.siply.redbus.constant.Gender;
import com.tech.interview.siply.redbus.entity.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "tbl_users")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
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
    public Date dateOfBirth;

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

    public User(UserDTO acc) {
        this.address1 = acc.getAddress1();
        this.age = acc.getAge();
        this.country = acc.getCountry();
        this.address2 = acc.getAddress2();
        this.city = acc.getCity();
        this.emailAddress = acc.getEmailAddress();
        this.firstName = acc.getFirstName();
        this.lastName = acc.getLastName();
        this.middleName = acc.getMiddleName();
        this.gender = acc.getGender();
        this.phoneNo = acc.getPhoneNo();
        this.preferredName = acc.getPreferredName();
        this.dateOfBirth = acc.getDateOfBirth();
        this.pincode = acc.getPincode();
    }
}
