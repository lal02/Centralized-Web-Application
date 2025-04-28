package com.lalbr.core.sensordata.soilhumidity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SoilHumidityRepository extends JpaRepository<SoilHumidityModel, Long> {
    List<SoilHumidityModel> findSoilHumidityModelsByTimestampBetweenAndSensorid(LocalDateTime startOfDay, LocalDateTime endOfDay,int sensorId);
    List<SoilHumidityModel> findSoilHumidityModelsBySensorid(int sensorId);

    SoilHumidityModel findFirstBySensoridOrderByTimestampDesc(int sensorId);
}
