package com.lalbr.core.recipe;

import jakarta.persistence.*;

@Entity
@Table(name = "recipe_ingredient")
public class IngredientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food")
    private FoodModel foodModel;

    @Column(name = "amount")
    private double amount;

    @Enumerated(EnumType.STRING)
    private Unit unit;

    public double getAmount() {
        return amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public FoodModel getFood() {
        return foodModel;
    }

    public void setFood(FoodModel foodModel) {
        this.foodModel = foodModel;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String toString(){
        return amount + " " +  unit + " " +  foodModel.getName() ;
    }

    public String toStringLogging(){
        return "IngredientModel " + "id: " + id + " amount: " + amount + " unit: " +  unit + " foodmodel: " +  foodModel ;
    }


}
