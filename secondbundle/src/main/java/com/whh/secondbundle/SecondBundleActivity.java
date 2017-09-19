package com.whh.secondbundle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.whh.commonlib.view.HorizontalView;
import com.whh.secondbundle.R;

/**
 * @author huscarter@163.com
 * @title
 * @description
 * @date 5/28/17
 */

public class SecondBundleActivity extends AppCompatActivity {
    private HorizontalView hv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_bundle);

        hv = (HorizontalView) findViewById(R.id.hv);
        hv.setLeftTextValue("left text");

        init();
    }

    private void init() {
        Toast.makeText(this, "hello world", Toast.LENGTH_SHORT).show();
    }
}
