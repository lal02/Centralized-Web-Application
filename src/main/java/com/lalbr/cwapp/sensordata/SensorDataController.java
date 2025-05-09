package com.lalbr.cwapp.sensordata;

import com.lalbr.cwapp.sensordata.airquality.AirqualityModel;
import com.lalbr.cwapp.sensordata.carbonmonoxide.COModel;
import com.lalbr.cwapp.sensordata.humidity.HumidityModel;
import com.lalbr.cwapp.sensordata.light.LightModel;
import com.lalbr.cwapp.sensordata.soilhumidity.SoilHumidityModel;
import com.lalbr.cwapp.sensordata.temperature.TemperatureModel;
import com.lalbr.cwapp.util.MailSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class  SensorDataController {

    Logger logger = LoggerFactory.getLogger(SensorDataController.class);

    @Autowired
    private SensorDataService sensorDataService;

    @Autowired
    private MailSenderService mailSenderService;

    private int temperatureCounter = 0;
    private int humidityCounter = 0;


    @GetMapping(value={"/sensordata","/sensor","/sensorData","/Sensor","/SensorData","/Sensordata"})
    public String getSensorData() {
        logger.info("########## sensorData get request ##########");
        return "sensordata";
    }

    @PostMapping("/temperature")
    public ResponseEntity<TemperatureModel> createTemperatureModel(@RequestBody TemperatureModel myModel) {
        logger.info("########## createTemperatureModel() - Start ##########");
        TemperatureModel savedModel = sensorDataService.saveTemperatureModel(myModel);
        if(savedModel.getValue()<18.5){
            if(temperatureCounter==3){
                String timestamp = "" + savedModel.getTimestamp();
                String subject = "Low Temperature Warning " + timestamp.substring(timestamp.length()-8,timestamp.length()-3);
                String content = "Warning, temperature is only " + savedModel.getValue() + "°C";
                mailSenderService.sendMailMessage(subject,content);
                temperatureCounter=0;
            }
            temperatureCounter++;
        }
        logger.info("########## sensorData createTemperatureModel() - End ##########");
        return ResponseEntity.ok(savedModel);
    }

    @PostMapping("/humidity")
    public ResponseEntity<HumidityModel> createHumidityModel(@RequestBody HumidityModel myModel) {
        logger.info("########## createHumidityModel() - Start ##########");
        HumidityModel savedModel = sensorDataService.saveHumidityModel(myModel);
        // send mail notification
        if(savedModel.getValue()>75){

            if(humidityCounter==3){
                String timestamp = "" + savedModel.getTimestamp();
                String subject = "Humidity Warning " + timestamp.substring(timestamp.length()-8,timestamp.length()-3);
                String content = "Warning, humidity is " + savedModel.getValue() + "%";
                mailSenderService.sendMailMessage(subject,content);
                humidityCounter=0;
            }
            else{
                humidityCounter++;
            }
        }
        logger.info("########## sensorData createHumidityModel() - End ##########");
        return ResponseEntity.ok(savedModel);
    }

    @PostMapping("/soilhumidity")
    public ResponseEntity<SoilHumidityModel> createSoilHumidityModel(@RequestBody SoilHumidityModel myModel) {
        logger.info("########## sensorData createSoilHumidityModel() - Start ##########");
        SoilHumidityModel savedModel = sensorDataService.saveSoilHumidityModel(myModel);
        logger.info("########## sensorData createSoilHumidityModel() - End ##########");
        return ResponseEntity.ok(savedModel);
    }
    @PostMapping("/light")
    public ResponseEntity<LightModel> createLightModel(@RequestBody LightModel myModel) {
        logger.info("########## sensorData createLightModel() - Start ##########");
        LightModel savedModel = sensorDataService.saveLightModel(myModel);
        logger.info("########## sensorData createLightModel() - End ##########");
        return ResponseEntity.ok(savedModel);
    }

    @PostMapping("/co")
    public ResponseEntity<COModel> createCOModel(@RequestBody COModel myModel) {
        logger.info("########## sensorData createCOModel() - Start ##########");
        COModel savedModel = sensorDataService.saveCOModel(myModel);
        logger.info("########## sensorData createCOModel() - End ##########");
        return ResponseEntity.ok(savedModel);
    }

    @PostMapping("/airquality")
    public ResponseEntity<AirqualityModel> createAirqualityModel(@RequestBody AirqualityModel myModel) {
        logger.info("########## sensorData createAirqualityModel() - Start ##########");
        AirqualityModel savedModel = sensorDataService.saveAirqualityModel(myModel);
        logger.info("########## sensorData createAirqualityModel() - End ##########");
        return ResponseEntity.ok(savedModel);
    }




}
