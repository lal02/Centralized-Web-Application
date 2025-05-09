package com.lalbr.cwapp.sensordata.soilhumidity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_soilhumidity")
public class SoilHumidityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "soilhumidity_id")
    private int id;

    @Column(name = "soilhumidity_value")
    private int value;
    @Column(name = "soilhumidity_timestamp")
    private LocalDateTime timestamp;

    // id = 0 => right plant (first sensor)
    // id = 1 => left plant (new sensor)
    @Column(name ="soilhumidity_sensorid")
    private int sensorid;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getSensorid() {
        return sensorid;
    }

    public void setSensorid(int sensorid) {
        this.sensorid = sensorid;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String toString(){
        return "SoilHumidityModedl id: " + id + " value: " + value + " timestamp: " + timestamp + " sensorid: " + sensorid;
    }
}
