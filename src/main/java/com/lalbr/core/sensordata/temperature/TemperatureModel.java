package com.lalbr.cwapp.sensordata.temperature;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_temperature")
public class TemperatureModel {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates the ID
    @Column(name="temperature_id")
    private int id;

    @Column(name = "temperature_value")
    private Double value;
    @Column(name = "temperature_timestamp")
    private LocalDateTime timestamp;


    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String toString(){
        return "TemperatureModel id: " + id + " value: " + value + " timestamp: " + timestamp;
    }
}
