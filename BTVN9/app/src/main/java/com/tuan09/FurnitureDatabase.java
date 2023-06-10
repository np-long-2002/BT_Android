package com.tuan09;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class FurnitureDatabase extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "Furniture.db";
    public static final String TABLE_FURNITURE = "Furniture";
    public static final String TABLE_CATEGORY = "Category";

    public FurnitureDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("PRAGMA foreign_keys = ON;");

        String createCategory =
                String.format(
                        "CREATE TABLE IF NOT EXISTS %s " +
                                "(" +
                                " CategoryID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                                " Name TEXT, " +
                                " Image TEXT " +
                                ");"
                        ,TABLE_CATEGORY);

        String createFurniture =
                String.format(
                        "CREATE TABLE IF NOT EXISTS %s " +
                                "(" +
                                " ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                                " Name TEXT, " +
                                " Image TEXT, " +
                                " Description TEXT," +
                                " CategoryID INTEGER, " +
                                " FOREIGN KEY(CategoryID) REFERENCES %s(CategoryID)" +
                                ");"
                        ,TABLE_FURNITURE, TABLE_CATEGORY);
        db.execSQL(createCategory);
        db.execSQL(createFurniture);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FURNITURE);
        onCreate(db);
    }
}

