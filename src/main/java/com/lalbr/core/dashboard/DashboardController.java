package com.lalbr.core.dashboard;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

@Autowired
DashboardService dashboardService;

@Autowired
APIConfigRepository apiConfigRepository;

@GetMapping("/")
public String getMappingDashboard(Model model){
    List<APIResult> apiResults = dashboardService.executeAPICalls();
    model.addAttribute("apiResults", apiResults);
    return "/index";
}

}
