package com.dev.energia.repository;

import com.dev.energia.model.MeasurementType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MeasurementTypeRepository extends JpaRepository<MeasurementType, Long> {

    Optional<MeasurementType> findByName(String name);

    boolean existsByName(String name);
}
