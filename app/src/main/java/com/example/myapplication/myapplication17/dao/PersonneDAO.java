package com.example.myapplication.myapplication17.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.myapplication17.bo.Personne;
import com.example.myapplication.myapplication17.contracts.PersonneContract;


public class PersonneDAO {
    private SQLiteDatabase db;
    private BddHelper helper;

    public PersonneDAO(Context ctx) {
        helper = new BddHelper(ctx);
        db = helper.getWritableDatabase();
    }

    public long insert(Personne personne){
        ContentValues values = new ContentValues();
        values.put(PersonneContract.COL_NOM, personne.getNom());
        values.put(PersonneContract.COL_PRENOM, personne.getPrenom());
        return db.insert(PersonneContract.TABLE_NAME, null, values);


    }
}
