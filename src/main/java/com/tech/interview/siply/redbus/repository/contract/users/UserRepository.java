package com.tech.interview.siply.redbus.repository.contract.users;

import com.tech.interview.siply.redbus.entity.dao.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmailAddress(String emailAddress);

    Optional<User> findByUserName(String userName);
}
