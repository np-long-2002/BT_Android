package com.tuan7;

import java.util.ArrayList;

public class Categories {
    public Categories(){}
    public Categories(String name, ArrayList<Furniture> arrayList) {
        this.name = name;
        this.arrayList = arrayList;
    }

    public Categories(String name, ArrayList<Furniture> arrayList, int image) {
        this.name = name;
        this.arrayList = arrayList;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Furniture> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Furniture> arrayList) {
        this.arrayList = arrayList;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    String name;
    ArrayList<Furniture> arrayList;
    int image;
    public ArrayList<Categories> getData(){
        ArrayList<Furniture> arrayListBed = new ArrayList<>();
        ArrayList<Furniture> arrayListRoom = new ArrayList<>();
        ArrayList<Furniture> arrayListMeeting = new ArrayList<>();
        ArrayList<Furniture> arrayListAss = new ArrayList<>();
        ArrayList<Categories> tmp = new ArrayList<>();
        tmp.add(new Categories("BedRoom",arrayListBed,R.drawable.hinhbai2));
        tmp.add(new Categories("LivingRoom",arrayListRoom,R.drawable.hinhbai2));
        tmp.add(new Categories("MeetingRoom",arrayListMeeting,R.drawable.hinhbai2));
        tmp.add(new Categories("Accessories",arrayListAss,R.drawable.hinhbai2));
        return tmp;
    }
}
