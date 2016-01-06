package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.test.ActivityInstrumentationTestCase2;
import android.test.mock.MockDialogInterface;
import android.util.Pair;

import java.util.concurrent.ExecutionException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class JokeFetchingTest extends ActivityInstrumentationTestCase2<MainActivity> {

    Activity mMActivity;

    public JokeFetchingTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mMActivity = getActivity();
    }

    public void testJokeFetching() {
        Context mockContext = mMActivity;
        DialogInterface mockDialog = new MockDialog();
        String joke = null;
        try {
            joke = new JokeRequestAsyncTask().execute(new Pair<Context, DialogInterface>(mockContext, mockDialog)).get();
        } catch (InterruptedException | ExecutionException e) {
        }
        assertNotNull("Server does not response", joke);
        assertNotSame("Requested joke should not be empty", joke, "");
    }

    class MockDialog extends MockDialogInterface {

        @Override
        public void dismiss() {
        }

        @Override
        public void cancel() {
        }
    }
}