package com.tech.interview.siply.redbus.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tech.interview.siply.redbus.constant.FuelType;
import com.tech.interview.siply.redbus.constant.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusDTO {
    private String name;
    private Status status;
    private String ownerName;
    private UUID ownerId;
    private Integer capacity;
    private String model;
    private String make;
    private Integer year;
    private Date registeredOn;
    private FuelType fuelType;
    private String registrationNo;
    private Boolean isPUCValid;
}
