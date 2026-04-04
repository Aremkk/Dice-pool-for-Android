package com.example.dicepool;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String databaseName = "rollshistory.db";
    private static final int schema = 1;
    static final String table = "rolls";

    public static final String columnId = "_id";
    public static final String columnRoll = "roll";
    public static final String columnResult = "result";

    public DatabaseHelper(Context context) {
        super(context, databaseName, null, schema);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE rolls (" + columnId
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + columnRoll
                + " TEXT, " + columnResult + " TEXT);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+table);
        onCreate(db);
    }
    public void clearTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table, null, null);
        db.close();
    }
}
