package com.lalbr.cwapp.recipe;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(name = "recipe")
public class RecipeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private long id;

    @Column(name = "recipe_name")
    private String name;

    @Column(name = "recipe_description")
    private String description;

    @ElementCollection(targetClass = Tags.class)
    @Enumerated(EnumType.STRING)
    private List<Tags> tags = new ArrayList<>();

    @ElementCollection(targetClass = Category.class)
    @Enumerated(EnumType.STRING)
    private List<Category> category = new ArrayList<>();

    @Column(name ="recipe_duration")
    @Enumerated(EnumType.STRING)
    private Duration duration;

    @Column(name = "recipe_mealprep")
    private boolean mealprep;

    //@Lob
    //private byte[] image;

    @ManyToMany
    @JoinTable(
            name = "recipe_ingredient_join",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<IngredientModel> ingredientModels = new ArrayList<>();


    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public List<IngredientModel> getIngredients() {
        return ingredientModels;
    }


    public Duration getDuration() {
        return duration;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIngredients(List<IngredientModel> ingredientModels) {
        this.ingredientModels = ingredientModels;
    }

    public void setMealprep(boolean mealprep) {
        this.mealprep = mealprep;
    }

    public boolean getMealPrep() {
        return mealprep;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public boolean isMealprep() {
        return mealprep;
    }

    public String getMealPrepStringGerman(){
        if(mealprep){
            return "Ja!";
        }
        return "Nein!";
    }


    public String getTagsAsString(){
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for(Tags tag : tags){
            if(!first){
                sb.append(", ");
            }
            sb.append(tag);
            first = false;
        }
        return sb.toString();
    }

    public String getCategoryAsString(){
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for(Category category : category){
            if(!first){
                sb.append(", ");
            }
            sb.append(category);
            first = false;
        }
        return sb.toString();
    }

    public String getIngredientsAsString(){
        StringBuilder sb = new StringBuilder();
        for(IngredientModel ingredientModel : ingredientModels){
            sb.append(ingredientModel.toString());
            sb.append("<br />");
        }

        System.out.println("sb");
        return sb.toString();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("RecipeModel ");
        sb.append("id: ").append(id).append("\n");
        sb.append("name: ").append(name).append("\n");
        sb.append("description: ").append(description).append("\n");

        sb.append("tags: ");
        tags.forEach(tag -> sb.append(tag).append(" "));
        sb.append("\n");

        sb.append("category: ");
        category.forEach(category -> sb.append(category).append(" "));
        sb.append("\n");

        sb.append("duration: ").append(duration).append("\n");
        sb.append("mealprep: ").append(mealprep).append("\n");

        sb.append("ingredients: ");
        ingredientModels.forEach(ingredient -> sb.append(ingredient.toStringLogging()).append(" "));
        sb.append("\n");

        return sb.toString();
    }

    public List<IngredientModel> getIngredientModels() {
        return ingredientModels;
    }

    public void setIngredientModels(List<IngredientModel> ingredientModels) {
        this.ingredientModels = ingredientModels;
    }
}
