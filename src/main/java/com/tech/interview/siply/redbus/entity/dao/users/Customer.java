package com.tech.interview.siply.redbus.entity.dao.users;

import com.tech.interview.siply.redbus.constant.Status;
import com.tech.interview.siply.redbus.constant.Type;
import com.tech.interview.siply.redbus.entity.dto.CustomerDTO;
import com.tech.interview.siply.redbus.entity.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "tbl_customers")
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {
    @Column(name = "subs_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public Customer(UserDTO userDTO, CustomerDTO customerDTO) {
        super(userDTO);
        this.type = customerDTO.getType();
        this.status = customerDTO.getStatus();
    }
}
