package com.lalbr.core.recipe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RecipeController {
    Logger logger = LoggerFactory.getLogger(RecipeController.class);
    @Autowired
    RecipeService recipeService;

    @GetMapping(value = {"/rezepte/{name}","/Rezepte/{name}"})
    public String rezepteTemplateGetMapping(@PathVariable String name, Model model){
        logger.info("########## rezepteTemplateGetMapping ##########");
        model.addAttribute("rezept", recipeService.findRezeptModelByName(name));
        return "rezepte/rezeptTemplate";
    }

    @GetMapping(value={"/rezepte","/Rezepte","/rezept","/Rezept","/rezepte/","/Rezepte"})
    public String rezeptOverviewGetMapping(Model model){
        logger.info("########## rezepteOverviewGetMapping ##########");
        List<RecipeModel> list = recipeService.findAllRezeptModel();
        model.addAttribute("rezeptList",list);
        return "rezepte/rezepte";
    }

    @GetMapping(value = {"/rezeptersteller","/rezeptErsteller","/recipecreator","/recipeCreator","/Rezeptersteller","/RezeptErsteller","/rezeptCreator","/RezeptCreator","/Rezeptcreator"})
    public String rezepterstellerGetMapping(Model model){
        logger.info("########## rezepterstellerGetMapping ##########");
        model.addAttribute("rezept",new RecipeModel());
        return "rezepte/rezeptErsteller";
    }


    @PostMapping("/rezeptersteller")
    public String rezepterstellerPost(@ModelAttribute RecipeModel recipeModel, Model model){
        logger.info("########## rezepterstellerPost ##########");
        model.addAttribute("rezept", recipeModel);
        return "sensordata";
    }

}
