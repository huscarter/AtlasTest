package com.whh.atlastest.activity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.whh.atlastest.R;
import com.whh.atlastest.atlas.Updater;
import com.whh.commonlib.view.HorizontalView;

import java.io.File;


public class UpdateActivity extends AppCompatActivity {
    private static final String TAG = UpdateActivity.class.getSimpleName();
    private HorizontalView hv_guide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        init();

        listFile(getBaseContext());
    }

    private void init() {

        hv_guide = (HorizontalView) findViewById(R.id.hv_guide);

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