package com.tuan09;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Database {
    private static Database _Ins;
    public static Database Ins(Context context)
    {
        _Ins = _Ins == null ? new Database(context) : _Ins;
        return _Ins;
    }
    public static Database Ins()
    {
        return _Ins;
    }

    private Database(Context context)
    {
        dbHelper = new FurnitureDatabase(context, FurnitureDatabase.DATABASE_NAME, null,1   );
    }


    public int insertRow(ContentValues contentValues, String nameTable)
    {
        int newRowID = (int) db.insert(nameTable, null, contentValues);
        return newRowID;
    }

    public Cursor getCursorListAll(String nameTable)
    {
        return db.query(
                nameTable,
                null,
                null,
                null,
                null,
                null,
                null);
    }

    FurnitureDatabase dbHelper;
    SQLiteDatabase db;

    public void openDatabase()
    {
        db = dbHelper.getWritableDatabase();
    }

    public void closeDatabase()
    {
        db.close();
    }

    public void resetDatabase()
    {
        dbHelper.onUpgrade(db, 1, 1);
    }
}

