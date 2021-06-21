package com.cts.ebilling.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.ebilling.model.Tariff;


@Repository
public interface TariffRepository extends JpaRepository<Tariff, Long> {



}