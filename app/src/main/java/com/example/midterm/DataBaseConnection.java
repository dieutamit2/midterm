package com.example.midterm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseConnection extends SQLiteOpenHelper {

    private final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS USER_INFO(" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            " EMAIL VARCHAR(50)," +
            " USER_NAME VARCHAR(200)," +
            " PASSWORD VARCHAR(50), " +
            " FULL_NAME VARCHAR(50)," +
            " EMAIL_INFO VARCHAR(50)," +
            " CONTACT VARCHAR(200)," +
            " ADDRESS VARCHAR(200))";

    public DataBaseConnection(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void createTable() {
        readQuery(CREATE_TABLE);
    }

    public void readQuery(String sql) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        sqLiteDatabase.execSQL(sql);
    }

    public void writeQuery(String sql) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(sql);
    }

    public Cursor getData(String sql) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
