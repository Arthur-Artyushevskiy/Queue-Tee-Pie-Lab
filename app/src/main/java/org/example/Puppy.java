package org.example;

public class Puppy implements Cutie {
    private String breed;
    private Integer rating;

    public Puppy(String breed) {}

    public Puppy(String breed, Integer rating) {
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
