package com.lalbr.cwapp.sensordata.airquality;

import com.lalbr.cwapp.sensordata.carbonmonoxide.COModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AirqualityRepository  extends JpaRepository<AirqualityModel, Long> {
    List<AirqualityModel> findAirqualityModelsByTimestampBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);

    AirqualityModel findTopByOrderByTimestampDesc();

    Integer deleteAllByValue(int value);
}