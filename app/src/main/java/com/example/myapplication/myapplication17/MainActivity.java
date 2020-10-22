package com.example.myapplication.myapplication17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.myapplication17.bo.Personne;
import com.example.myapplication.myapplication17.dao.PersonneDAO;

import java.util.List;

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

        PersonneDAO dao = new PersonneDAO(this);
        Personne personne = new Personne(1, "Jira", "Go");
        dao.update(personne);
        List<Personne> personnes = dao.get();
        long id = dao.insert((Personne) personne);
        for (Personne item : personnes){
            Log.i(TAG, item.toString());
        }
    }
}