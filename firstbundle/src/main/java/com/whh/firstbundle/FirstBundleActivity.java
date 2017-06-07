package com.whh.firstbundle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * @author huscarter@163.com
 * @title
 * @description
 * @date 5/28/17
 */

public class FirstBundleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_bundle);

        init();
    }

    private void init() {
        Toast.makeText(this, "hello world", Toast.LENGTH_SHORT).show();
    }
}
