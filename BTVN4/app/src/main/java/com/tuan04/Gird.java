package com.tuan04;

import java.util.ArrayList;

public class Gird {
    public Gird(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Gird(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int id;
    private String name;
    public ArrayList<Gird> getData(){
        ArrayList<Gird> arrayList =new ArrayList<>();
        arrayList.add(new Gird(R.drawable.car,"Cars and Bikes"));
        arrayList.add(new Gird(R.drawable.mobile,"Mobiles & Tablets"));
        arrayList.add(new Gird(R.drawable.cpt,"Electronics & Appliances"));
        arrayList.add(new Gird(R.drawable.home,"Real Estate"));
        arrayList.add(new Gird(R.drawable.life,"Home & Lifestyle"));
        arrayList.add(new Gird(R.drawable.jobs,"Jobs"));
        arrayList.add(new Gird(R.drawable.setting,"Services"));
        arrayList.add(new Gird(R.drawable.movi,"Entertainment"));
        arrayList.add(new Gird(R.drawable.education,"Education & Learning"));
        return arrayList;
    }
}
