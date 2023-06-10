package com.tuan09;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Categories {

    int categoryID;

    String name;
    ArrayList<Furniture> dataSource;
    String filenameImage;



    Bitmap image;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Furniture> getDataSource() {
        return dataSource;
    }

    public void setDataSource(ArrayList<Furniture> dataSource) {
        this.dataSource = dataSource;
    }

    public Bitmap getImage() {
        return image;
    }
    public void setImage(Bitmap image) {
        this.image = image;
    }


    public String getFilenameImage() {
        return filenameImage;
    }

    public void setFilenameImage(String filenameImage) {
        this.filenameImage = filenameImage;
    }

    public Categories(String name, ArrayList<Furniture> dataSource, Bitmap image) {
        this.name = name;
        this.dataSource = dataSource;
        this.image = image;
    }

    public Categories(int categoryID, String name, String filenameImage) {
        this.categoryID = categoryID;
        this.name = name;
        this.filenameImage = filenameImage;
    }

    public static Bitmap convertStringToBitmapFromAsset(Context context, String filename)
    {
        AssetManager assetManager = context.getAssets();

        try
        {
            InputStream is = assetManager.open(filename);
            Bitmap image = BitmapFactory.decodeStream(is);
            return image;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public ContentValues toContentValues()
    {
        ContentValues returnValue = new ContentValues();
        returnValue.put("Name", name);
        returnValue.put("Image", filenameImage);
        return returnValue;
    }

    public static ArrayList<Categories> convertCursorToListObject(Cursor cursor)
    {
        ArrayList<Categories> returnValue = new ArrayList<>();
        while (cursor.moveToNext())
        {
            returnValue.add(convertCursorToObject(cursor));
        }
        cursor.close();
        return returnValue;
    }

    public static Categories convertCursorToObject(Cursor cursor)
    {
        int categoryID = cursor.getInt(cursor.getColumnIndexOrThrow("CategoryID"));
        String name = cursor.getString(cursor.getColumnIndexOrThrow("Name"));
        String image = cursor.getString(cursor.getColumnIndexOrThrow("Image"));
        return new Categories(categoryID, name, image);
    }



}

