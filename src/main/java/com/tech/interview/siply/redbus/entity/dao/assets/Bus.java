package com.tech.interview.siply.redbus.entity.dao.assets;

import com.tech.interview.siply.redbus.constant.FuelType;
import com.tech.interview.siply.redbus.constant.Status;
import com.tech.interview.siply.redbus.entity.dto.BusDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tbl_buses")
@AllArgsConstructor
@NoArgsConstructor
public class Bus {
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    public Date updatedAt;
    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "status", nullable = false)
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
    @Column(name = "fuel_type", nullable = false)
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

    public Bus(BusDTO busDTO) {
        this.name = busDTO.getName();
        this.status = busDTO.getStatus();
        this.ownerId = busDTO.getOwnerId();
        this.capacity = busDTO.getCapacity();
        this.model = busDTO.getModel();
        this.make = busDTO.getMake();
        this.year = busDTO.getYear();
        this.registeredOn = busDTO.getRegisteredOn();
        this.fuelType = busDTO.getFuelType();
        this.registrationNo = busDTO.getRegistrationNo();
        this.isPUCValid = busDTO.getIsPUCValid();
    }
}
