package com.tech.interview.siply.redbus.entity.dao.users;

import com.tech.interview.siply.redbus.constant.Status;
import com.tech.interview.siply.redbus.entity.dto.OwnerDTO;
import com.tech.interview.siply.redbus.entity.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_owners")
@AllArgsConstructor
@NoArgsConstructor
public class Owner extends User implements Serializable {
    @Column(name = "no_of_buses", nullable = false)
    private Integer noOfBuses;
    @Column(name = "agency_name", nullable = true)
    private String agencyName;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public Owner(UserDTO userDTO, OwnerDTO ownerDTO) {
        super(userDTO);
        this.status = ownerDTO.getStatus();
        this.noOfBuses = ownerDTO.getNoOfBuses();
        this.agencyName = ownerDTO.getAgencyName();
    }
}
