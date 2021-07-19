package com.tech.interview.siply.redbus.repository.contract.assets;

import com.tech.interview.siply.redbus.entity.dao.assets.Bus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BusRepository extends JpaRepository<Bus, UUID> {
    List<Bus> findAllByOwnerId(UUID ownerId, Pageable pageable);
}
