package com.whh.atlastest;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import java.io.File;
import java.util.List;


public class UpdateActivity extends AppCompatActivity {
    private static final String TAG = UpdateActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        init();

        listFile(getBaseContext());
    }

    private void init() {

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AsyncTask<Void, Void, Void>() {
                        @Override
                        protected Void doInBackground(Void... voids) {
                            Updater.update(getBaseContext());
                            return null;
                        }

                        @Override
                        protected void onPostExecute(Void aVoid) {
//                            android.os.Process.killProcess(android.os.Process.myPid());
                        }
                    }.execute();
                }
            });
        }
    }


    private void listFile(Context context) {
        File dir = context.getExternalCacheDir();
        if (dir.exists() && dir.isDirectory()) {
            File[] list = dir.listFiles();
            for (File file : list) {
                Log.i(TAG, "file name:" + file.getName());
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

}