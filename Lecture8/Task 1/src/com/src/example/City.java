package com.src.example;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private String country;
    private Long population;
    private List<String> languages;

    public City() {
        languages = new ArrayList<>();
    }

    public City(String name, String country, Long population, List<String> languages) {
        this.name = name;
        this.country = country;
        this.population = population;
        this.languages = languages;
    }

    public City(String name, String country, Long population) {
        this.name = name;
        this.country = country;
        this.population = population;
        this.languages = new ArrayList<>();
    }

    public void addLanguage(String language){
        if(languages == null)
            languages = new ArrayList<>();
        languages.add(language);
    }

    public List<String> getLanguages() {
        return languages;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", population='" + population + '\'' +
                ", languages=" + languages +
                '}';
    }
}
