package com.lalbr.core.sensordata;

import com.lalbr.core.sensordata.airquality.AirqualityModel;
import com.lalbr.core.sensordata.airquality.AirqualityRepository;
import com.lalbr.core.sensordata.carbonmonoxide.COModel;
import com.lalbr.core.sensordata.carbonmonoxide.CORepository;
import com.lalbr.core.sensordata.humidity.HumidityModel;
import com.lalbr.core.sensordata.humidity.HumidityRepository;
import com.lalbr.core.sensordata.light.LightModel;
import com.lalbr.core.sensordata.light.LightRepository;
import com.lalbr.core.sensordata.soilhumidity.SoilHumidityModel;
import com.lalbr.core.sensordata.soilhumidity.SoilHumidityRepository;
import com.lalbr.core.sensordata.temperature.TemperatureModel;
import com.lalbr.core.sensordata.temperature.TemperatureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SensorDataService {

    Logger logger = LoggerFactory.getLogger(SensorDataService.class);

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Autowired
    private HumidityRepository humidityRepository;

    @Autowired
    private SoilHumidityRepository soilHumidityRepository;

    @Autowired
    private LightRepository lightRepository;

    @Autowired
    private CORepository coRepository;

    @Autowired
    private AirqualityRepository airqualityRepository;

    public List<TemperatureModel> getTemperatureData(TimeSpan timespan) throws Exception {
        if(timespan == TimeSpan.ALL){
            logger.info("########## getTemperatureData() - TimeSpan ALL ##########");
            return temperatureRepository.findAll();
        }
        LocalDateTime[] arr = getStartAndEndDate(timespan);
        logger.info("########## getTemperatureData() - TimeSpan {} until {}##########", arr[0], arr[1]);
        return temperatureRepository.findTemperatureModelsByTimestampBetween(arr[0],arr[1]);
    }


    public List<HumidityModel> getHumidityData(TimeSpan timespan) throws Exception {
        if(timespan == TimeSpan.ALL){
            logger.info("########## getHumidityData() - TimeSpan ALL ##########");
            return humidityRepository.findAll();
        }
        LocalDateTime[] arr = getStartAndEndDate(timespan);
        logger.info("########## getHumidityData() - TimeSpan {} until {}##########", arr[0], arr[1]);
        return humidityRepository.findHumidityModelsByTimestampBetween(arr[0],arr[1]);
    }

    public List<SoilHumidityModel> getSoilHumidityData(TimeSpan timespan,int sensorID) throws Exception {
        if(timespan == TimeSpan.ALL){
            logger.info("########## getSoilHumidityData() - TimeSpan ALL ##########");
            return soilHumidityRepository.findSoilHumidityModelsBySensorid(sensorID);
        }
        LocalDateTime[] arr = getStartAndEndDate(timespan);
        logger.info("########## getSoilHumidityData() - TimeSpan {} until {}##########", arr[0], arr[1]);
        return soilHumidityRepository.findSoilHumidityModelsByTimestampBetweenAndSensorid(arr[0],arr[1],sensorID);
    }

    public List<LightModel> getLightData(TimeSpan timespan) throws Exception {
        if(timespan == TimeSpan.ALL){
            logger.info("########## getLightData() - TimeSpan ALL ##########");
            return lightRepository.findAll();
        }
        LocalDateTime[] arr = getStartAndEndDate(timespan);
        logger.info("########## getLightData() - TimeSpan {} until {}##########", arr[0], arr[1]);
        return lightRepository.findLightModelsByTimestampBetween(arr[0],arr[1]);
    }

    public List<AirqualityModel> getAQData(TimeSpan timespan) throws Exception {
        if(timespan == TimeSpan.ALL){
            logger.info("########## getAQData() - TimeSpan ALL ##########");
            return airqualityRepository.findAll();
        }
        LocalDateTime[] arr = getStartAndEndDate(timespan);
        logger.info("########## getAQData() - TimeSpan {} until {}##########", arr[0], arr[1]);
        return airqualityRepository.findAirqualityModelsByTimestampBetween(arr[0],arr[1]);
    }

    public List<COModel> getCOData(TimeSpan timespan) throws Exception {
       if(timespan == TimeSpan.ALL){
           logger.info("########## getCOData() - TimeSpan ALL ##########");
           return coRepository.findAll();
       }
       LocalDateTime[] arr = getStartAndEndDate(timespan);
        logger.info("########## getCOData() - TimeSpan {} until {}##########", arr[0], arr[1]);
        return coRepository.findCOModelsByTimestampBetween(arr[0],arr[1]);
    }

    /*
        SAVING
     */

    public TemperatureModel saveTemperatureModel(TemperatureModel temperatureModel) {
        TemperatureModel savedTemperatureModel = temperatureRepository.save(temperatureModel);
        logger.info("########## saveTemperatureModel() - Start##########");
        logger.info(temperatureModel.toString());
        logger.info("########## saveTemperatureModel() - End##########");
        return savedTemperatureModel;
    }

    public SoilHumidityModel saveSoilHumidityModel(SoilHumidityModel soilHumidityModel) {
        SoilHumidityModel savedSoilHumidityModedl = soilHumidityRepository.save(soilHumidityModel);
        logger.info("########## saveSoilHumidityModel() - Start##########");
        logger.info(soilHumidityModel.toString());
        logger.info("########## saveSoilHumidityModel() - End##########");
        return savedSoilHumidityModedl;
    }

    public LightModel saveLightModel(LightModel lightModel) {
        LightModel savedLightModel = lightRepository.save(lightModel);
        logger.info("########## saveLightModel() - Start##########");
        logger.info(lightModel.toString());
        logger.info("########## saveLightModel() - End##########");
        return savedLightModel;
    }

    public COModel saveCOModel(COModel coModel){
        COModel savedCOModel = coRepository.save(coModel);
        logger.info("########## saveCOModel() - Start##########");
        logger.info(coModel.toString());
        logger.info("########## saveCOModel() - End##########");
        return savedCOModel;
    }

    public AirqualityModel saveAirqualityModel(AirqualityModel airqualityModel){
        AirqualityModel savedAirqualityModel = airqualityRepository.save(airqualityModel);
        logger.info("########## saveAirqualityModel() - Start##########");
        logger.info(airqualityModel.toString());
        logger.info("########## saveAirqualityModel() - End##########");
        return savedAirqualityModel;
    }

    public HumidityModel saveHumidityModel(HumidityModel humidityModel) {
        HumidityModel savedHumidityModel = humidityRepository.save(humidityModel);
        logger.info("########## saveHumidityModel() - Start##########");
        logger.info(humidityModel.toString());
        logger.info("########## saveHumidityModel() - End##########");
        return savedHumidityModel;
    }

    private LocalDateTime[] getStartAndEndDate(TimeSpan timespan){
        LocalDateTime start;
        LocalDateTime end;

        switch (timespan) {
            case TODAY -> {
                start = LocalDate.now().atStartOfDay();
                end = LocalDate.now().plusDays(1).atStartOfDay();
            }
            case WEEK -> {
                start = LocalDate.now().atStartOfDay().minusWeeks(1);
                end = LocalDate.now().plusDays(1).atStartOfDay();
            }
            case THIS_MONTH -> {
                start = LocalDate.now().withDayOfMonth(1).atStartOfDay();
                end = LocalDate.now().plusDays(LocalDate.now().lengthOfMonth() + 1).atStartOfDay();
            }
            case THIS_YEAR -> {
                start = LocalDate.now().withDayOfYear(1).atStartOfDay();
                end = LocalDate.now().withDayOfYear(1).plusYears(1).atStartOfDay();
            }
            default -> throw new IllegalStateException("Unexpected value: " + timespan);
        }

        return new LocalDateTime[] {
            start,
            end
        };
    }


    /*
        mobile data
     */

    public TemperatureModel getNewestTemperatureModel(){
        return temperatureRepository.findTopByOrderByTimestampDesc();
    }

    public HumidityModel getNewestHumidityModel(){
        return humidityRepository.findTopByOrderByTimestampDesc();
    }

    public LightModel getNewestLightModel(){
        return lightRepository.findTopByOrderByTimestampDesc();
    }

    public COModel getNewestCOModel(){
        return coRepository.findTopByOrderByTimestampDesc();
    }

    public AirqualityModel getNewestAirqualityModel(){
        return airqualityRepository.findTopByOrderByTimestampDesc();
    }

    public SoilHumidityModel getNewestSoilHumidityModel(int id){
        return soilHumidityRepository.findFirstBySensoridOrderByTimestampDesc(id);
    }

    public Integer deleteAllTemperatureByValue(double value){
        return temperatureRepository.deleteAllByValue(value);
    }

    public Integer deleteAllHumidityByValue(double value){
        return humidityRepository.deleteAllByValue(value);
    }

    public Integer deleteAllSoilHumidityByValue(int value){
        return soilHumidityRepository.deleteSoilHumidityModelsByValue(value);
    }

    public Integer deleteAllCOByValue(int value){
        return coRepository.deleteAllByValue(value);
    }

    public Integer deleteAllAirqualityByValue(int value){
        return airqualityRepository.deleteAllByValue(value);
    }

    public Integer deleteAllLightByValue(int value){
        return lightRepository.deleteAllByValue(value);
    }
}
