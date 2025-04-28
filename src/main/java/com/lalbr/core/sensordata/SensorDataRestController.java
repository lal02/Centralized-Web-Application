package com.lalbr.core.sensordata;

import com.lalbr.core.sensordata.airquality.AirqualityModel;
import com.lalbr.core.sensordata.carbonmonoxide.COModel;
import com.lalbr.core.sensordata.humidity.HumidityModel;
import com.lalbr.core.sensordata.light.LightModel;
import com.lalbr.core.sensordata.soilhumidity.SoilHumidityModel;
import com.lalbr.core.sensordata.temperature.TemperatureModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.List;

@RestController
public class SensorDataRestController {
    Logger logger = LoggerFactory.getLogger(SensorDataRestController.class);
    @Autowired
    SensorDataService sensorDataService;
    /*
        For mobile app
     */
    @GetMapping("/api/mobile/temperature/newest")
    public TemperatureModel getNewestTemperature() throws Exception {
        logger.info("########## getNewestTemperature() - Start ##########");
        TemperatureModel temperatureModel = sensorDataService.getNewestTemperatureModel();
        System.out.println(temperatureModel);
        logger.info("########## getNewestTemperature() - End ##########");
        return temperatureModel;
    }

    @GetMapping("/api/mobile/humidity/newest")
    public HumidityModel getNewestHumidity() throws Exception {
        logger.info("########## getNewestHumidity() - Start ##########");
        HumidityModel humidityModel = sensorDataService.getNewestHumidityModel();
        System.out.println(humidityModel);
        logger.info("########## getNewestHumidity() - End ##########");
        return humidityModel;
    }

    @GetMapping("/api/mobile/light/newest")
    public LightModel getNewestLight() throws Exception {
        logger.info("########## getNewestLight() - Start ##########");
        LightModel lightModel = sensorDataService.getNewestLightModel();
        System.out.println(lightModel);
        logger.info("########## getNewestLight() - End ##########");
        return lightModel;
    }

    @GetMapping("/api/mobile/co/newest")
    public COModel getNewestCO() throws Exception {
        logger.info("########## getNewestCO() - Start ##########");
        COModel coModel = sensorDataService.getNewestCOModel();
        System.out.println(coModel);
        logger.info("########## getNewestCO() - End ##########");
        return coModel;
    }

    @GetMapping("/api/mobile/airquality/newest")
    public AirqualityModel getNewestAirquality() throws Exception {
        logger.info("########## getNewestAirquality() - Start ##########");
        AirqualityModel airqualityModel = sensorDataService.getNewestAirqualityModel();
        System.out.println(airqualityModel);
        logger.info("########## getNewestAirquality() - End ##########");
        return airqualityModel;
    }

    @GetMapping("/api/mobile/soilhumidity/newest/{id}")
    public SoilHumidityModel getNewestSoilHumidity(@PathVariable int id) throws Exception {
        logger.info("########## getNewestSoilHumidity({}) sensorid- Start ##########",id);
        SoilHumidityModel soilHumidityModel = sensorDataService.getNewestSoilHumidityModel(id);
        System.out.println(soilHumidityModel);
        logger.info("########## getNewestSoilHumidity({}) sensorid - End ##########",id);
        return soilHumidityModel;
    }


    /*
        for webapp
     */
    @GetMapping("/api/temperatur/all")
    public List<TemperatureModel> getTemperatureData() throws Exception {
        logger.info("########## getTemperatureData() ##########");
        return sensorDataService.getTemperatureData(TimeSpan.ALL);
    }


    @GetMapping("/api/temperatur/today")
    public List<TemperatureModel> getTemperatureDataToday()throws Exception {
        logger.info("########## getTemperatureDataToday() ##########");
        return sensorDataService.getTemperatureData(TimeSpan.TODAY);
    }

    @GetMapping("/api/temperatur/week")
    public List<TemperatureModel> getTemperatureDataWeek()throws Exception {
        logger.info("########## getTemperatureDataWeek() ##########");
        return sensorDataService.getTemperatureData(TimeSpan.WEEK);
    }

    @GetMapping("/api/temperatur/month")
    public List<TemperatureModel> getTemperatureDataMonth()throws Exception{
        logger.info("########## getTemperatureDataMonth() ##########");
        return sensorDataService.getTemperatureData(TimeSpan.THIS_MONTH);
    }

    @GetMapping("/api/temperatur/year")
    public List<TemperatureModel> getTemperatureDataYear() throws Exception{
        logger.info("########## getTemperatureDataYear() ##########");
        return sensorDataService.getTemperatureData(TimeSpan.THIS_YEAR);
    }


    /*
        HUMIDITY ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    @GetMapping("/api/humidity/all")
    public List<HumidityModel> getHumidityData() throws Exception {
        logger.info("########## getHumidityData() ##########");
        return sensorDataService.getHumidityData(TimeSpan.ALL);
    }

    @GetMapping("/api/humidity/today")
    public List<HumidityModel> getHumidityDataToday() throws Exception {
        logger.info("########## getHumidityDataToday() ##########");
        return sensorDataService.getHumidityData(TimeSpan.TODAY);
    }

    @GetMapping("/api/humidity/week")
    public List<HumidityModel> getHumidityDataWeek()throws Exception {
        logger.info("########## getHumidityDataWeek() ##########");
        return sensorDataService.getHumidityData(TimeSpan.WEEK);
    }

    @GetMapping("/api/humidity/month")
    public List<HumidityModel> getHumidityDataMonth() throws Exception {
        logger.info("########## getHumidityDataMonth() ##########");
        return sensorDataService.getHumidityData(TimeSpan.THIS_MONTH);
    }

    @GetMapping("/api/humidity/year")
    public List<HumidityModel> getHumidityDataYear() throws Exception {
        logger.info("########## getHumidityDataYear() ##########");
        return sensorDataService.getHumidityData(TimeSpan.THIS_YEAR);
    }

    /*
        SOIL HUMIDITY RIGHT PLANT ( SENSORID 0) ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    @GetMapping("/api/soilhumidity/all/{sensorid}")
    public List<SoilHumidityModel> getSoilHumidityDataAll(@PathVariable int sensorid) throws Exception {
        logger.info("########## getSoilHumidityDataAll() ##########");
        return sensorDataService.getSoilHumidityData(TimeSpan.ALL,sensorid);
    }
    @GetMapping("/api/soilhumidity/today/{sensorid}")
    public List<SoilHumidityModel> getSoilHumidityDataToday(@PathVariable int sensorid) throws Exception {
        logger.info("########## getSoilHumidityDataToday() ##########");
        return sensorDataService.getSoilHumidityData(TimeSpan.TODAY,sensorid);
    }

    @GetMapping("/api/soilhumidity/week/{sensorid}")
    public List<SoilHumidityModel> getSoilHumidityDataWeek(@PathVariable int sensorid)throws Exception {
        logger.info("########## getSoilHumidityDataWeek() ##########");
        return sensorDataService.getSoilHumidityData(TimeSpan.WEEK,sensorid);
    }

    @GetMapping("/api/soilhumidity/month/{sensorid}")
    public List<SoilHumidityModel> getSoilHumidityDataMonth(@PathVariable int sensorid) throws Exception {
        logger.info("########## getSoilHumidityDataMonth() ##########");
        return sensorDataService.getSoilHumidityData(TimeSpan.THIS_MONTH,sensorid);
    }
    @GetMapping("/api/soilhumidity/year/{sensorid}")
    public List<SoilHumidityModel> getSoilHumidityDataYear(@PathVariable int sensorid) throws Exception {
        logger.info("########## getSoilHumidityDataYear() ##########");
        System.out.println(sensorid);
        return sensorDataService.getSoilHumidityData(TimeSpan.THIS_YEAR,sensorid);
    }


    /*
        LIGHT DATA ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    @GetMapping("/api/light/all")
    public List<LightModel> getLightDataAll() throws Exception {
        logger.info("########## getLightDataAll() ##########");
        return sensorDataService.getLightData(TimeSpan.ALL);
    }
    @GetMapping("/api/light/today")
    public List<LightModel> getLightDataToday() throws Exception {
        logger.info("########## getLightDataToday() ##########");
        return sensorDataService.getLightData(TimeSpan.TODAY);
    }

    @GetMapping("/api/light/week")
    public List<LightModel> getLightDataWeek()throws Exception {
        logger.info("########## getLightDataWeek() ##########");
        return sensorDataService.getLightData(TimeSpan.WEEK);
    }

    @GetMapping("/api/light/month")
    public List<LightModel> getLightDataMonth() throws Exception {
        logger.info("########## getLightDataMonth() ##########");
        return sensorDataService.getLightData(TimeSpan.THIS_MONTH);
    }
    @GetMapping("/api/light/year")
    public List<LightModel> getLightDataYear() throws Exception {
        logger.info("########## getLightDataYear() ##########");
        return sensorDataService.getLightData(TimeSpan.THIS_YEAR);
    }
    /*
        AQ DATA ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    @GetMapping("/api/aq/all")
    public List<AirqualityModel> getAQtDataAll() throws Exception {
        logger.info("########## getAQtDataAll() ##########");
        return sensorDataService.getAQData(TimeSpan.ALL);
    }
    @GetMapping("/api/aq/today")
    public List<AirqualityModel> getAQDataToday() throws Exception {
        logger.info("########## getAQDataToday() ##########");
        return sensorDataService.getAQData(TimeSpan.TODAY);
    }

    @GetMapping("/api/aq/week")
    public List<AirqualityModel> getAQDataWeek()throws Exception {
        logger.info("########## getAQDataWeek() ##########");
        return sensorDataService.getAQData(TimeSpan.WEEK);
    }

    @GetMapping("/api/aq/month")
    public List<AirqualityModel> getAQDataMonth() throws Exception {
        logger.info("########## getAQDataMonth() ##########");
        return sensorDataService.getAQData(TimeSpan.THIS_MONTH);
    }
    @GetMapping("/api/aq/year")
    public List<AirqualityModel> getAQDataYear() throws Exception {
        logger.info("########## getAQDataYear() ##########");
        return sensorDataService.getAQData(TimeSpan.THIS_YEAR);
    }



    /*
        CO DATA ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */
    @GetMapping("/api/co/all")
    public List<COModel> getCOtDataAll() throws Exception {
        logger.info("########## getCOtDataAll() ##########");
        return sensorDataService.getCOData(TimeSpan.ALL);
    }
    @GetMapping("/api/co/today")
    public List<COModel> getCODataToday() throws Exception {
        logger.info("########## getCODataToday() ##########");
        return sensorDataService.getCOData(TimeSpan.TODAY);
    }

    @GetMapping("/api/co/week")
    public List<COModel> getCODataWeek() throws Exception {
        logger.info("########## getCODataWeek() ##########");
        return sensorDataService.getCOData(TimeSpan.WEEK);
    }

    @GetMapping("/api/co/month")
    public List<COModel> getCODataMonth() throws Exception {
        logger.info("########## getCODataMonth() ##########");
        return sensorDataService.getCOData(TimeSpan.THIS_MONTH);
    }
    @GetMapping("/api/co/year")
    public List<COModel> getCODataYear() throws Exception {
        logger.info("########## getCODataYear() ##########");
        return sensorDataService.getCOData(TimeSpan.THIS_YEAR);
    }




}
