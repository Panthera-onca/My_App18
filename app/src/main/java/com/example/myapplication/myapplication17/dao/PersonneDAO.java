package com.example.myapplication.myapplication17.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.myapplication.myapplication17.bo.Personne;
import com.example.myapplication.myapplication17.contracts.PersonneContract;

import java.util.ArrayList;
import java.util.List;


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

    public Personne get(long id){
        Personne personne = null;

        Cursor cursor = db.query(
                PersonneContract.TABLE_NAME,
                new String[]{PersonneContract.COL_ID, PersonneContract.COL_NOM,PersonneContract.COL_PRENOM},
                PersonneContract.COL_ID + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);

        if(cursor.moveToNext()){
            personne = new Personne();
            personne.setId(cursor.getInt(cursor.getColumnIndex(PersonneContract.COL_ID.trim())));
            personne.setNom(cursor.getString(cursor.getColumnIndex(PersonneContract.COL_NOM.trim())));
            personne.setPrenom(cursor.getString(cursor.getColumnIndex(PersonneContract.COL_PRENOM.trim())));
        }
        return personne;
    }

    public List<Personne> get(){
        List<Personne> resultat = new ArrayList<>();
        Cursor cursor = db.query(
                PersonneContract.TABLE_NAME,
                new String[]{PersonneContract.COL_ID, PersonneContract.COL_NOM, PersonneContract.COL_PRENOM},
                null,
                null,
                null,
                null,
                null);
        while(cursor.moveToNext()){
            Personne personne = new Personne();
            personne.setId(cursor.getInt(cursor.getColumnIndex(PersonneContract.COL_ID.trim())));
            personne.setNom(cursor.getString(cursor.getColumnIndex(PersonneContract.COL_NOM.trim())));
            personne.setPrenom(cursor.getString(cursor.getColumnIndex(PersonneContract.COL_PRENOM.trim())));
            resultat.add(personne);

        }
        return resultat;

    }

    public boolean update(Personne personne){
        Log.i("ACOS", "Entreedans update avec" + personne.toString());

        ContentValues cv = new ContentValues();
        cv.put(PersonneContract.COL_NOM, personne.getNom());
        cv.put(PersonneContract.COL_PRENOM, personne.getPrenom());
        return db.update(PersonneContract.TABLE_NAME, cv, PersonneContract.COL_ID + "=?", new String[]{String.valueOf(personne.getId())})>0;
    }

    public boolean delete(Personne personne){
        return db.delete(PersonneContract.TABLE_NAME, PersonneContract.COL_ID + "=?", new String[]{String.valueOf(personne.getId())})>0;
    }
}
