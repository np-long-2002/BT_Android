package com.tuan7;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;

public class Furniture implements Serializable {
    public Furniture(){}
    public Furniture(String name, String description, int image) {
        this.name = name;
        this.description = description;
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

    public int getImage() {
        return image;
    }

    public void setImage (int image){
        this.image = image;
    }

    String name;
    String description;
    int image;
    public ArrayList<Furniture> getData(){
        ArrayList<Furniture> arrayList = new ArrayList<>();
        arrayList.add(new Furniture("Hình 1","Một trong những con vật được xem là người bạn thân thiết với con người nhất là con chó Chó thông minh, có thể giúp bạn nhiều công việc. Chính vì thế mà chó là con vật mà tôi yêu thích nhất",R.drawable.hinhbai2));
        arrayList.add(new Furniture("Hình 2","Một trong những con vật được xem là người bạn thân thiết với con người nhất là con chó Chó thông minh, có thể giúp bạn nhiều công việc. Chính vì thế mà chó là con vật mà tôi yêu thích nhất",R.drawable.hinhbai2));
        arrayList.add(new Furniture("Hình 3","Một trong những con vật được xem là người bạn thân thiết với con người nhất là con chó Chó thông minh, có thể giúp bạn nhiều công việc. Chính vì thế mà chó là con vật mà tôi yêu thích nhất",R.drawable.hinhbai2));
        arrayList.add(new Furniture("Hình 4","Một trong những con vật được xem là người bạn thân thiết với con người nhất là con chó Chó thông minh, có thể giúp bạn nhiều công việc. Chính vì thế mà chó là con vật mà tôi yêu thích nhất",R.drawable.hinhbai2));
        arrayList.add(new Furniture("Hình 5","Một trong những con vật được xem là người bạn thân thiết với con người nhất là con chó Chó thông minh, có thể giúp bạn nhiều công việc. Chính vì thế mà chó là con vật mà tôi yêu thích nhất",R.drawable.hinhbai2));
        arrayList.add(new Furniture("Hình 6","Một trong những con vật được xem là người bạn thân thiết với con người nhất là con chó Chó thông minh, có thể giúp bạn nhiều công việc. Chính vì thế mà chó là con vật mà tôi yêu thích nhất",R.drawable.hinhbai2));
        arrayList.add(new Furniture("Hình 7","Một trong những con vật được xem là người bạn thân thiết với con người nhất là con chó Chó thông minh, có thể giúp bạn nhiều công việc. Chính vì thế mà chó là con vật mà tôi yêu thích nhất",R.drawable.hinhbai2));
        arrayList.add(new Furniture("Hình 8","Một trong những con vật được xem là người bạn thân thiết với con người nhất là con chó Chó thông minh, có thể giúp bạn nhiều công việc. Chính vì thế mà chó là con vật mà tôi yêu thích nhất",R.drawable.hinhbai2));
        arrayList.add(new Furniture("Hình 9","Một trong những con vật được xem là người bạn thân thiết với con người nhất là con chó Chó thông minh, có thể giúp bạn nhiều công việc. Chính vì thế mà chó là con vật mà tôi yêu thích nhất",R.drawable.hinhbai2));
        arrayList.add(new Furniture("Hình 10","Một trong những con vật được xem là người bạn thân thiết với con người nhất là con chó Chó thông minh, có thể giúp bạn nhiều công việc. Chính vì thế mà chó là con vật mà tôi yêu thích nhất",R.drawable.hinhbai2));
        return arrayList;
    }
}
