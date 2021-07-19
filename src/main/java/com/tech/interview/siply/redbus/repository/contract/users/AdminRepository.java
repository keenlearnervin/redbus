package com.tech.interview.siply.redbus.repository.contract.users;

import com.tech.interview.siply.redbus.entity.dao.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AdminRepository extends JpaRepository<Admin, UUID> {
    Optional<Admin> findByUserName(String userName);

    @Override
    void deleteById(UUID uuid);
}
