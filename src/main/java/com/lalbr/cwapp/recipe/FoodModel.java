package com.lalbr.cwapp.recipe;

import jakarta.persistence.*;

@Entity
@Table(name = "recipe_food")
public class FoodModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long id;

    @Column(name = "food_name")
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "FoodModel " + "id: " + id + " name: " + name;
    }
}
