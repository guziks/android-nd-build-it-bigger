package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;

public class MainActivity extends AppCompatActivity implements JokeCounter {

    private ProgressDialog mProgress;
    private AsyncTask mRequest;
    private int mJokeCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mProgress != null) {
            mProgress.dismiss();
        }
        if (mRequest != null) {
            mRequest.cancel(true);
        }
    }

    public void tellJoke(View view){
        mJokeCounter++;
        mProgress = ProgressDialog.show(this, getString(R.string.progress_dialog_title), getString(R.string.progress_dialog_message), true);
        mRequest = new JokeRequestAsyncTask().execute(new Pair<Context, DialogInterface>(this, mProgress));
    }

    public int getCount() {
        return mJokeCounter;
    }
}

interface JokeCounter {
    int getCount();
}
