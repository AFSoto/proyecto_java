package com.dev.energia.repository;

import com.dev.energia.model.EnergyType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface EnergyTypeRepository extends JpaRepository<EnergyType, Long> {

    Optional<EnergyType> findByName(String name);

    boolean existsByName(String name);

    List<EnergyType> findByRenewable(Boolean renewable);
}