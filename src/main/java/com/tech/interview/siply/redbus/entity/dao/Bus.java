package com.tech.interview.siply.redbus.entity.dao;

import com.tech.interview.siply.redbus.constant.FuelType;
import com.tech.interview.siply.redbus.constant.Status;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tbl_buses")
@AllArgsConstructor
@NoArgsConstructor
public class Bus {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "status",nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "owner_id")
    private UUID ownerId;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "model")
    private String model;

    @Column(name = "make")
    private String make;

    @Column(name = "year")
    private Integer year;

    @Column(name = "registered_on")
    private Date registeredOn;

    @Column(name = "fuel_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Column(name = "registration_number")
    private String registrationNo;

    @Column(name = "is_puc_valid")
    private Boolean isPUCValid;

    @Column(name = "created_at", nullable = true, updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedAt;
}
