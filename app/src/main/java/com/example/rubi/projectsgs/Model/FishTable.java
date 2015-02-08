package com.example.rubi.projectsgs.Model;

/**
 * Created by Rubi on 02/02/2015.
 */
public class FishTable {

    public FishTable() {
    }
    public static final String TABLE_NAME = "fish_data";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_MATERIAL = "material";
    public static final String COLUMN_METHOD = "method";
    public static final String COLUMN_KITCHEN = "kitchen";
    public static final String COLUMN_IMAGE = "image";

    public static final String[] ALL_COLUMNS = {
            FishTable.COLUMN_ID, FishTable.COLUMN_TYPE, FishTable.COLUMN_NAME,
            FishTable.COLUMN_MATERIAL, FishTable.COLUMN_METHOD,FishTable.COLUMN_KITCHEN, FishTable.COLUMN_IMAGE
    };

}

