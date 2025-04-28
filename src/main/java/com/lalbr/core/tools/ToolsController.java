package com.lalbr.core.tools;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToolsController {

    @GetMapping("/tools/converter")
    public String converterGetMapping() {
        return "/tools/converter";
    }

    @GetMapping("/tools/finanzrechner")
    public String finanzrechnerGetMapping(){
        return "/tools/finanzrechner";
    }

    @GetMapping("/tools/finnishconjugation")
    public String finnConjGetMapping(){
        return "/tools/finnishconjugation";
    }

    @GetMapping("/tools/gamescalculator")
    public String gamescalculatorGetMapping(){
        return "/tools/gamescalculator";
    }
    @GetMapping("/tools/passwordgenerator")
    public String passwordgeneratorGetMapping(){
        return "/tools/passwordgenerator";
    }

    @GetMapping("/tools/counter")
    public String counterGetMapping(){
        return "/tools/counter";
    }



}
