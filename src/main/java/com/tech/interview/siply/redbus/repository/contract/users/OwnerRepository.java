package com.tech.interview.siply.redbus.repository.contract.users;

import com.tech.interview.siply.redbus.entity.dao.users.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, UUID> {
    Optional<Owner> findByUserName(String userName);
}
