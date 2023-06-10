package com.tuan04;

import java.util.ArrayList;
import java.util.List;

public class Country {
    public Country(int id, String countryName, String population) {
        this.id = id;
        this.countryName = countryName;
        this.population = population;
    }
    public Country(){

    }
    private int id;
    private String countryName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }


    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    private String population;
    public ArrayList<Country> getListData() {
        ArrayList<Country> list = new ArrayList<Country>();
        Country vietnam = new Country(R.drawable.vn,"Vietnam" , "98000000");
        Country usa = new Country(R.drawable.united,"United States", "320000000");
        Country russia = new Country(R.drawable.russia,"Russia", "142000000");
        Country australia = new Country(R.drawable.uc,"Australia", "23766305");
        Country japan = new Country(R.drawable.japan,"Japan",  "126788677");
        list.add(vietnam);
        list.add(usa);
        list.add(russia);
        list.add(australia);
        list.add(japan);
        return list;
    }
}
