package com.tuan7;

import java.util.ArrayList;

public class Utils {
    static ArrayList<Furniture> furnituresHistory = new ArrayList<>();

    public  void addFurnitureHistory(Furniture furniture){
        if(furnituresHistory.indexOf(furniture)>0){
            this.furnituresHistory.add(0,furniture);
        }
    }
    public ArrayList<Furniture>getFurnituresHistory(){
        return this.furnituresHistory;
    }
}
