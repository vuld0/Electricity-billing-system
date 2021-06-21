package com.cts.ebilling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.cts.ebilling.model.Outage;


@Repository
public interface OutageRepository extends JpaRepository<Outage, Long> {
}




