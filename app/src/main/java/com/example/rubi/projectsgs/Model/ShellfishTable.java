package com.example.rubi.projectsgs.Model;

/**
 * Created by Rubi on 11/02/2015.
 */
public class ShellfishTable {

    public ShellfishTable() {
    }

    public static final String TABLE_NAME = "Shellfish_data";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_MATERIAL = "material";
    public static final String COLUMN_METHOD = "method";
    public static final String COLUMN_KITCHEN = "kitchen";
    public static final String COLUMN_IMAGE = "image";

    public static final String[] ALL_COLUMNS = {
            ShellfishTable.COLUMN_ID, ShellfishTable.COLUMN_TYPE, ShellfishTable.COLUMN_NAME,
            ShellfishTable.COLUMN_MATERIAL, ShellfishTable.COLUMN_METHOD,ShellfishTable.COLUMN_KITCHEN, ShellfishTable.COLUMN_IMAGE
    };
}
