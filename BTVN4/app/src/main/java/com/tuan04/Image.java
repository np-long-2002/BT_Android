package com.tuan04;

import java.util.ArrayList;

public class Image {
    public Image(int id, String nameCheck) {
        this.id = id;
        this.nameCheck = nameCheck;
    }
    public Image(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCheck() {
        return nameCheck;
    }

    public void setNameCheck(String nameCheck) {
        this.nameCheck = nameCheck;
    }

    private int id;
    private String nameCheck;
    protected ArrayList<Image> getdata(){
        ArrayList<Image> images= new ArrayList<>();
        images.add(new Image(R.drawable.education,"hình 1"));
        images.add(new Image(R.drawable.education,"hình 2"));
        images.add(new Image(R.drawable.education,"hình 3"));
        images.add(new Image(R.drawable.education,"hình 4"));
        images.add(new Image(R.drawable.education,"hình 5"));
        images.add(new Image(R.drawable.education,"hình 6"));
        images.add(new Image(R.drawable.education,"hình 7"));
        images.add(new Image(R.drawable.education,"hình 8"));
        images.add(new Image(R.drawable.education,"hình 9"));
        images.add(new Image(R.drawable.education,"hình 10"));
        return images;
    }
}
