package com.tech.interview.siply.redbus.entity.dao.users;

import com.tech.interview.siply.redbus.constant.Status;
import com.tech.interview.siply.redbus.entity.dto.AdminDTO;
import com.tech.interview.siply.redbus.entity.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_admins")
@NoArgsConstructor
@AllArgsConstructor
//@OnDelete(action = OnDeleteAction.CASCADE)
@PrimaryKeyJoinColumn(name = "id")
@Getter
public class Admin extends User implements Serializable {
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public Admin(UserDTO userDTO, AdminDTO ownerDTO) {
        super(userDTO);
        this.status = ownerDTO.getStatus();
    }
}
