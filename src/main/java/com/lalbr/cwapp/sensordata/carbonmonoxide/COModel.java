package com.lalbr.cwapp.sensordata.carbonmonoxide;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="sensor_co")
public class COModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates the ID
    @Column(name = "co_id")
    private long id;

    @Column(name = "co_value")
    private int value;
    @Column(name = "co_timestamp")
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
        return "COModel id: " + id + " value: " + value + " timestamp: " + timestamp;
    }
}
