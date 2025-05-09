package com.lalbr.cwapp.sensordata.temperature;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TemperatureRepository extends JpaRepository<TemperatureModel, Long> {


    List<TemperatureModel> findTemperatureModelsByTimestampBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);

    TemperatureModel findTopByOrderByTimestampDesc();

    Integer deleteAllByValue(double Value);
}
