package com.example.myapplication.myapplication17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.myapplication17.bo.Personne;
import com.example.myapplication.myapplication17.dao.PersonneDAO;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "ACOS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Personne personne = new Personne("Anthony", "Cosson");

        PersonneDAO dao = new PersonneDAO(this);
        long id = dao.insert(personne);
        Log.i(TAG, "Id de l'insertion:" + id);
    }
}