package com.example.sqlandroid2.mainsql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sqlandroid2.maindb.MainDB;

public class MainSql extends SQLiteOpenHelper {
    public static String NAME ="main.db";
    public static int VERSION = 1;
    public MainSql(Context context){
        super(context,NAME,null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MainDB.MAIN_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MainDB.MAIN_TABLE);
    }
}
