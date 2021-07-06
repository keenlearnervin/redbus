package com.tech.interview.siply.redbus.entity.dao.users;

import com.tech.interview.siply.redbus.constant.Status;
import com.tech.interview.siply.redbus.entity.dto.DriverDTO;
import com.tech.interview.siply.redbus.entity.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_drivers")
@AllArgsConstructor
@NoArgsConstructor
public class Driver extends User implements Serializable {
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "license_number", nullable = false)
    private String licenseNo;

    public Driver(UserDTO userDTO, DriverDTO driverDTO) {
        super(userDTO);
        this.status = driverDTO.getStatus();
        this.licenseNo = driverDTO.getLicenseNo();
    }
}
