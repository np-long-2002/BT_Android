package com.tuan09;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.util.ArrayList;

public class Furniture {

    int ID;
    int categoryID;



    String name;
    String description;
    Bitmap image;
    String filenameImage;

    public String getFilenameImage() {
        return filenameImage;
    }

    public void setFilenameImage(String filenameImage) {
        this.filenameImage = filenameImage;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Furniture(String name, String description, Bitmap image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Furniture(int ID, int categoryID, String name, String description, String filenameImage) {
        this.ID = ID;
        this.categoryID = categoryID;
        this.name = name;
        this.description = description;
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
        ContentValues returnValues = new ContentValues();
        returnValues.put("Name", name);
        returnValues.put("Image", filenameImage);
        returnValues.put("Description", description);
        returnValues.put("CategoryID", categoryID);
        return returnValues;
    }

    public static ArrayList<Furniture> convertCursorToListObject(Cursor cursor)
    {
        ArrayList<Furniture> returnValue = new ArrayList<>();
        while (cursor.moveToNext())
        {
            returnValue.add(convertCursorToObject(cursor));
        }
        cursor.close();
        return returnValue;
    }

    public static Furniture convertCursorToObject(Cursor cursor)
    {
        int ID = cursor.getInt(cursor.getColumnIndexOrThrow("ID"));
        String name = cursor.getString(cursor.getColumnIndexOrThrow("Name"));
        String filenameImage = cursor.getString(cursor.getColumnIndexOrThrow("Image"));
        String description = cursor.getString(cursor.getColumnIndexOrThrow("Description"));
        int categoryID = cursor.getInt(cursor.getColumnIndexOrThrow("CategoryID"));
        return new Furniture(ID, categoryID, name, description, filenameImage);
    }
}
