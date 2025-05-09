package com.lalbr.cwapp.dashboard;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DashboardService {

    private final Logger logger = LoggerFactory.getLogger(DashboardService.class);

    @Autowired
    APIConfigRepository apiConfigRepository;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public DashboardService(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
        this.restTemplate = restTemplateBuilder.build();
        this.objectMapper = objectMapper;
    }

    public List<APIResult> executeAPICalls() {
        List<APIConfigModel> apiConfigs = apiConfigRepository.findAll();
        return apiConfigs.stream().map(apiConfig -> {
            APIResult apiResult = new APIResult();
            apiResult.setTitle(apiConfig.getName());

            String url = apiConfig.getUrl();
            List<APIConfigField> fields = apiConfig.getFields();
            logger.info("API Call to URL : {}", url);

            String jsonResponse = restTemplate.getForObject(url, String.class);
            logger.info("API Response : {}", jsonResponse);

            JsonNode rootNode = null;
            try {
                rootNode = objectMapper.readTree(jsonResponse);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            JsonNode finalRootNode = rootNode;
            StringBuilder stringBuilder = new StringBuilder();
            fields.stream().map(field -> {
                String[] path = field.getJson_name().split("\\.");
                JsonNode fieldNode = finalRootNode;

                if(field.getJson_name().contains("[")){
                    fieldNode = fieldNode.at("/" + field.getJson_name().replace(".","/").replace("]","").replace("[","/"));
                }
                else{
                    for (String part : path) {
                        fieldNode = fieldNode.path(part);
                    }
                }
                return field.getDisplay_name() + ": " + (fieldNode.isMissingNode() ? "N/A" : fieldNode.asText()) + "<br>";
            }).toList().forEach(stringBuilder::append);
            apiResult.setValue(stringBuilder.toString());
            return apiResult;
        }).toList();
    }




}
