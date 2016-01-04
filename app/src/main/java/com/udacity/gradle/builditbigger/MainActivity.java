package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.udacity.gradle.joker.Joker;
import com.udacity.gradle.jokeviewer.JokeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view){
        Joker joker = new Joker();
        String joke = joker.tell();
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(JokeActivity.EXTRA_jOKE, joke);
        startActivity(intent);
    }

    public void requestJoke(View view) {
        new JokeRequestAsyncTask().execute(new Pair<Context, String>(this, "Serge"));
    }
}
