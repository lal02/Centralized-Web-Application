package com.lalbr.core.recipe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    Logger logger = LoggerFactory.getLogger(RecipeService.class);

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    public RecipeModel findRezeptModelByName(String name) {
        logger.info("########## findRezeptModelByName({}) - Start ##########",name);
        RecipeModel recipeModel = recipeRepository.findRezeptModelByName(name);
        logger.info(recipeModel.toString());
        logger.info("########## findRezeptModelByName({}) - End ##########",name);
        return recipeModel;
    }

    public List<RecipeModel> findAllRezeptModel() {
        List<RecipeModel> recipeModels = recipeRepository.findAll();
        logger.info("########## findAllRezeptModel() - Start ##########");
        recipeModels.forEach(recipeModel -> {logger.info(recipeModel.toString());});
        logger.info("########## findAllRezeptModel() - End ##########");
        return recipeModels;
    }

    public List<IngredientModel> findAllIngredientModel() {
        List<IngredientModel> ingredientModels = ingredientRepository.findAll();
        logger.info("########## findAllIngredientModel() - Start ##########");
        ingredientModels.forEach(ingredientModel -> {logger.info(ingredientModel.toString());});
        logger.info("########## findAllIngredientModel() - End ##########");
        return ingredientModels;
    }

    public RecipeModel saveRezeptModel(RecipeModel recipeModel) {
        RecipeModel recipeModelSaved = recipeRepository.save(recipeModel);
        logger.info("########## saveRezeptModel() - Start ##########");
        logger.info(recipeModelSaved.toString());
        logger.info("########## saveRezeptModel() - End ##########");
        return recipeModelSaved;
    }
}
