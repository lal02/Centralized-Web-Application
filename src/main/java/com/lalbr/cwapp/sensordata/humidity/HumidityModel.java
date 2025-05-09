package com.lalbr.cwapp.sensordata.humidity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_humidity")
public class HumidityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates the ID
    @Column(name = "humidity_id")
    private int id;

    @Column(name = "humidity_value")
    private double value;
    @Column(name = "humidity_timestamp")
    private  LocalDateTime timestamp;


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        return "HumidityModel id: " + id + " value: " + value + " timestamp: " + timestamp;
    }
}
