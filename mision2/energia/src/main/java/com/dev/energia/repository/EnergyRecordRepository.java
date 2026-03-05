package com.dev.energia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dev.energia.model.EnergyRecord;

import java.util.List;

public interface EnergyRecordRepository extends JpaRepository<EnergyRecord, Long> {

    List<EnergyRecord> findByPowerPlantId(Long powerPlantId);

    List<EnergyRecord> findByYear(Integer year);

    boolean existsByPowerPlantIdAndYearAndMonthAndMeasurementTypeId(
            Long powerPlantId,
            Integer year,
            Integer month,
            Long measurementTypeId
    );
}