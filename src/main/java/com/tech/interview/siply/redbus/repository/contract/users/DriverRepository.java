package com.tech.interview.siply.redbus.repository.contract.users;

import com.tech.interview.siply.redbus.entity.dao.users.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DriverRepository extends JpaRepository<Driver, UUID> {
    Optional<Driver> findByUserName(String userName);
}
