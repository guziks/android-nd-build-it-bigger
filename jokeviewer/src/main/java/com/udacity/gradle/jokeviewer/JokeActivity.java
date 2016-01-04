package com.udacity.gradle.jokeviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private static final String TAG = JokeActivity.class.getSimpleName();

    public static final String EXTRA_jOKE = "extra_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView jokeView = (TextView) findViewById(R.id.joke_view);
        String joke = getIntent().getStringExtra(EXTRA_jOKE);
        if (joke != null) {
            Log.i(TAG, getString(R.string.log_joke_received, joke));
            jokeView.setText(joke);
        } else {
            Log.i(TAG, getString(R.string.log_no_joke_received));
        }
    }
}
