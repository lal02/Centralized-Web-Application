package com.lalbr.cwapp.sensordata.airquality;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="sensor_airquality")
public class AirqualityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airquality_id")
    private long id;

    @Column(name = "airquality_value")
    private  int value;

    @Column(name = "airquality_timestamp")
    private LocalDateTime timestamp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String toString(){
        return "AirqualityModel id: " + id + " value: " + value + " timestamp: " + timestamp;
    }
}
