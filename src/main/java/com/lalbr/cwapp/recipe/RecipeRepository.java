package com.lalbr.cwapp.recipe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<RecipeModel,Long> {

    RecipeModel findRezeptModelByName(String name);


}


