package com.example.sqlandroid2.maindb;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqlandroid2.mainmodel.MainModel;
import com.example.sqlandroid2.mainsql.MainSql;

public class MainDB {

    MainSql mainSql;
    SQLiteDatabase sqLiteDatabase;

    public static final String MAIN_ID = "mainId";
    public static final String MAIN_NAME = "mainName";

    public static final String MAIN_TABLE = "table_main";

    public static final String MAIN_SQL ="Create table "+ MAIN_TABLE +"(" +
            MAIN_ID + "text primary key, " +
            MAIN_NAME + "text )";


    public MainDB(Context context){
        mainSql = new MainSql(context);
        sqLiteDatabase = mainSql.getWritableDatabase();
    }

    public long insertMain(MainModel model){
        ContentValues values = new ContentValues();
        values.put(MAIN_ID,model.getMainId());
        values.put(MAIN_NAME,model.getMainName());


        if (sqLiteDatabase.insert(MAIN_TABLE, null, values)<0){
            return -1;
        }else {
            return 1;
        }
    }

}
