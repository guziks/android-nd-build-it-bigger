package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view){
        ProgressDialog progress = ProgressDialog.show(this, getString(R.string.progress_dialog_title), getString(R.string.progress_dialog_message), true);
        new JokeRequestAsyncTask().execute(new Pair<Context, ProgressDialog>(this, progress));
    }
}
