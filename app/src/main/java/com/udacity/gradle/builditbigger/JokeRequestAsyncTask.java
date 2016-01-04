package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.jokeviewer.JokeActivity;

import java.io.IOException;

class JokeRequestAsyncTask extends AsyncTask<Pair<Context, ProgressDialog>, Void, String> {

    private static final String TAG = JokeRequestAsyncTask.class.getSimpleName();

    private static MyApi mApiService = null;
    private Context mContext;
    private ProgressDialog mProgress;

    @Override
    protected String doInBackground(Pair<Context, ProgressDialog>... params) {
        if(mApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

//            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
//                    .setRootUrl("https://android-nd-build-it-bigger.appspot.com/_ah/api/");

            mApiService = builder.build();
        }

        mContext = params[0].first;
        mProgress = params[0].second;

        String joke = mContext.getString(R.string.default_joke);

        try {
            joke = mApiService.tellJoke().execute().getText();
            Log.i(TAG, "Requested joke: " + joke);
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }

        return joke;
    }

    @Override
    protected void onPostExecute(String result) {
        mProgress.dismiss();
        Intent intent = new Intent(mContext, JokeActivity.class);
        intent.putExtra(JokeActivity.EXTRA_jOKE, result);
        mContext.startActivity(intent);
    }
}
