package com.bai01;

import java.util.ArrayList;

public class Food {
    int id;
    String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    String name;
    float price;
    public Food(int id, String type, String name, float price) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.price = price;
    }
    public static ArrayList initFood(){
        ArrayList<Food> arrList = new ArrayList<>();
        arrList.add(new Food(R.drawable.food, "Pizza", "Spicy Chicken Pizza", 310));
        arrList.add(new Food(R.drawable.food, "Burger", "Beef Burger", 350));
        arrList.add(new Food(R.drawable.food, "Pizza", "Chicken Pizza", 250));
        arrList.add(new Food(R.drawable.food, "Burger", "Chicken Burger", 350));
        arrList.add(new Food(R.drawable.food, "Burger", "Fish Burger", 310));
        arrList.add(new Food(R.drawable.food, "Mango", "Mango Juice", 250));
        return arrList;
    }
}
