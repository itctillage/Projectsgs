package com.example.rubi.projectsgs.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.rubi.projectsgs.Model.FishObject;
import com.example.rubi.projectsgs.Model.FishTable;
import com.example.rubi.projectsgs.utils.SeafoodConstant;

import java.util.ArrayList;



/**
 * Created by Rubi on 03/02/2015.
 */
public class SeafoodDBSource
{
    public static final String TAG = SeafoodDBSource.class.getSimpleName();
    private SQLiteDatabase database;
    private SeafoodDBHelper dbHelper;

    public SeafoodDBSource(Context context)
    {
        dbHelper = new SeafoodDBHelper(context);
    }

    public void open()
    {
        database = dbHelper.getWritableDatabase();
    }

    public void close()
    {
        dbHelper.close();
    }

    public FishObject insertFish(FishObject fishes)
    {
        ContentValues values = new ContentValues();
        values.put(FishTable.COLUMN_MATERIAL, fishes.getCookingMaterials());
        values.put(FishTable.COLUMN_IMAGE, fishes.getImageId());
        values.put(FishTable.COLUMN_METHOD, fishes.getCookingMethod());
        values.put(FishTable.COLUMN_NAME, fishes.getCookingName());
        values.put(FishTable.COLUMN_TYPE, fishes.getType());
        values.put(FishTable.COLUMN_KITCHEN, fishes.getKitchen());
        long insertId = database.insert(FishTable.TABLE_NAME, null,
                values);
        Cursor cursor = database.query(FishTable.TABLE_NAME,
                FishTable.ALL_COLUMNS, FishTable.COLUMN_ID + " = " + insertId, null,
                null, null, null, null);

        cursor.moveToFirst();
        FishObject newFish = cursorToFish(cursor);
        cursor.close();
        Log.v(TAG, " Insert Fish " + newFish.getCookingName());
        return newFish;
    }

    private FishObject cursorToFish(Cursor cursor)
    {
        FishObject fishObject = new FishObject();
        fishObject.setFishId(cursor.getLong(0));
        fishObject.setType(cursor.getString(1));
        fishObject.setCookingName(cursor.getString(2));
        fishObject.setCookingMaterials(cursor.getString(3));
        fishObject.setCookingMethod(cursor.getString(4));
        fishObject.setKitchen(cursor.getString(5));
        fishObject.setImageId(cursor.getInt(6));
        return fishObject;

    }

    public boolean isFishTableEmpty()
    {
        String count = "SELECT count(*) FROM "+FishTable.TABLE_NAME;
        Cursor mcursor = database.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if(icount>0)
            return false;
        else
            return true;
    }
    public ArrayList<FishObject> getAllFish()
    {
        ArrayList<FishObject> fishList = new ArrayList<FishObject>();

        Cursor cursor = database.query(FishTable.TABLE_NAME,
                FishTable.ALL_COLUMNS, "type = '" + SeafoodConstant.TYPE_FISH + "'", null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            FishObject fishObject = cursorToFish(cursor);
            fishList.add(fishObject);
            cursor.moveToNext();
        }
        cursor.close();
        return fishList;
    }
    public ArrayList<FishObject> getAllShellfish()
    {
        ArrayList<FishObject> shellfishList = new ArrayList<FishObject>();

        Cursor cursor = database.query(FishTable.TABLE_NAME,
                FishTable.ALL_COLUMNS, "type = '" + SeafoodConstant.TYPE_SHELLFISH + "'", null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            FishObject fishObject = cursorToFish(cursor);
            shellfishList.add(fishObject);
            cursor.moveToNext();
        }
        cursor.close();
        return shellfishList;
    }

}
