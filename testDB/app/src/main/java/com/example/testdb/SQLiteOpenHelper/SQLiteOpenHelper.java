package com.example.testdb.SQLiteOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class SQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper {

    final String CREATE_USER = "CREATE TABLE users (id INTEGER, name TEXT, age INTEGER)";

    public SQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER); //Se creara la tabla users
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }
}
