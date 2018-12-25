package com.example.moham.portfolio_2;

public class Recipe {

    private String name;
    private String description;
    private String steps;
    private int rating;
    private int image;

    public Recipe(String name, String description, String steps, int rating, int image) {
        this.name = name;
        this.description = description;
        this.steps = steps;
        this.rating = rating;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
