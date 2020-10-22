package com.example.myapplication.myapplication17.contracts;

public class PersonneContract {
    public static final String TABLE_NAME = "personnes";
    public static final String COL_ID = "id";
    public static final String COL_NOM = "nom";
    public static final String COL_PRENOM = "prenom";

    public static final String CREATE_TABLE = "CREATE_TABLE" + TABLE_NAME
            + "(" +
            COL_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
            COL_NOM + "TEXT," +
            COL_PRENOM + "TEXT" + ");";
    public static final String DROP_TABLE = "DROP_TABLE" + TABLE_NAME;

}
