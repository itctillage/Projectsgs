package com.example.rubi.projectsgs.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.rubi.projectsgs.Model.FishTable;

/**
 * Created by Rubi on 05/02/2015.
 */
public class SeafoodDBHelper extends SQLiteOpenHelper {

    private static final String db_name = "fishCooking.db";
    private static final int db_version = 3;
    private Context ctx;

    private static final String db_create_fishCooking = "create table "
            + FishTable.TABLE_NAME + "("
            + FishTable.COLUMN_ID + " integer primary key autoincrement, "
            + FishTable.COLUMN_NAME + " varchar(50) not null, "
            + FishTable.COLUMN_MATERIAL + " varchar(50) not null, "
            + FishTable.COLUMN_TYPE + " varchar(50) not null, "
            + FishTable.COLUMN_METHOD + " varchar(50) not null, "
            + FishTable.COLUMN_KITCHEN + " varchar(50) not null, "
            + FishTable.COLUMN_IMAGE + " text not null);";

    public SeafoodDBHelper(Context context) {
        super(context, db_name, null, db_version);
        ctx = context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(db_create_fishCooking);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}