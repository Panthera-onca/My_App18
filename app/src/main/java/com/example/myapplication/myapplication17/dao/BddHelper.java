package com.example.myapplication.myapplication17.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.myapplication.myapplication17.contracts.PersonneContract;

public class BddHelper extends SQLiteOpenHelper {

    private static final int VERSION = 2;
    private static final String BDD_NAME = "demonstrations.db";
    private static final String TAG = "ACOS";
    public BddHelper(@Nullable Context context) {
        super(context, BDD_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "P&assage dans le onCreate");
        db.execSQL(PersonneContract.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PersonneContract.CREATE_TABLE);
        onCreate(db);

    }
}
