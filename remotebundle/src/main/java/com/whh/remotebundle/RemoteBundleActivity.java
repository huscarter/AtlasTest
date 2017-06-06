package com.whh.remotebundle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @author huscarter@163.com
 * @title
 * @description
 * @date 6/5/17
 */

public class RemoteBundleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_remote_bundle);

        init(state);

        setListener();
    }

    private void init(Bundle state) {

    }

    private void setListener() {

    }
}
