package com.lalbr.cwapp.apitests;

import com.lalbr.cwapp.sensordata.SensorDataService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class SensorDataTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    SensorDataService sensorDataService;

    @Test
    public void testPostTemperature() throws Exception {
        String json = "{\"value\":-1.0,\"timestamp\":\"2026-11-01T23:13:36\"}";
        mockMvc.perform(post("/temperature")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
        int amount = sensorDataService.deleteAllTemperatureByValue(-1);
        boolean deleted =  amount > 0;
        assertTrue(deleted);
    }

    @Test
    public void testPostHumidity() throws Exception {
        String json = "{\"value\":-1.0,\"timestamp\":\"2026-11-01T23:13:36\"}";
        mockMvc.perform(post("/humidity")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
        int amount = sensorDataService.deleteAllHumidityByValue(-1);
        boolean deleted =  amount > 0;
        assertTrue(deleted);
    }

    @Test
    public void testPostSoilHumidity() throws Exception {
        String json = "{\"value\":-1.0,\"timestamp\":\"2026-11-01T23:13:36\",\"sensorid\":-1}";
        mockMvc.perform(post("/soilhumidity")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
        int amount = sensorDataService.deleteAllSoilHumidityByValue(-1);
        boolean deleted =  amount > 0;
        assertTrue(deleted);
    }

    @Test
    public void testPostCO() throws Exception {
        String json = "{\"value\":-1,\"timestamp\":\"2026-11-01T23:13:36\"}";
        mockMvc.perform(post("/co")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
        int amount = sensorDataService.deleteAllCOByValue(-1);
        boolean deleted =  amount > 0;
        assertTrue(deleted);
    }

    @Test
    public void testPostAirquality() throws Exception {
        String json = "{\"value\":-1,\"timestamp\":\"2026-11-01T23:13:36\"}";
        mockMvc.perform(post("/airquality")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
        int amount = sensorDataService.deleteAllAirqualityByValue(-1);
        boolean deleted =  amount > 0;
        assertTrue(deleted);
    }

    @Test
    public void testPostLight() throws Exception {
        String json = "{\"value\":-1,\"timestamp\":\"2026-11-01T23:13:36\"}";
        mockMvc.perform(post("/light")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
        int amount = sensorDataService.deleteAllLightByValue(-1);
        boolean deleted =  amount > 0;
        assertTrue(deleted);
    }
}
