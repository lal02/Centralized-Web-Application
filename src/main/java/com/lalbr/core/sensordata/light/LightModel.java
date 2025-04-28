package com.lalbr.core.sensordata.light;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_light")
public class LightModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "light_id")
    private int id;

    @Column(name = "light_value")
    private Double value;

    @Column(name = "light_timestamp")
    private LocalDateTime timestamp;


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Double getValue() {
        return value;
    }

    public String toString(){
        return "LightModel id: " + id + " value: " + value + " timestamp: " + timestamp;
    }
}
