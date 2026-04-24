package org.example;

public class PygmyMarmoset implements Cutie {
    private String breed;
    private Integer rating;

    public PygmyMarmoset() {}

    public PygmyMarmoset(String breed, Integer rating) {
        this.breed = breed;
        this.rating = rating;
    }

    @Override
    public String description() {
        return "A very cute " + breed;
    }

    @Override
    public Integer cutenessRating() {
        return rating;
    }
}