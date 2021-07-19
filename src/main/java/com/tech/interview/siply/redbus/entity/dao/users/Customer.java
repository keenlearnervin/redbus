package com.tech.interview.siply.redbus.entity.dao.users;

import com.tech.interview.siply.redbus.constant.Status;
import com.tech.interview.siply.redbus.constant.Type;
import com.tech.interview.siply.redbus.entity.dto.CustomerDTO;
import com.tech.interview.siply.redbus.entity.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "tbl_customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Customer extends User implements Serializable {
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
