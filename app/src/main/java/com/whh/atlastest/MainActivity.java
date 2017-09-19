package com.whh.atlastest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private Toolbar toolbar;
    private ActivityGroupDelegate activity_delegate;
    private ViewGroup activity_container;


    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_main);

        init(state);

        setListener();
    }

    private void init(Bundle state) {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("main page");
        toolbar.inflateMenu(R.menu.main_menu);

        activity_delegate = new ActivityGroupDelegate(this, state);
        activity_container = (ViewGroup) findViewById(R.id.content);

        TextView tv_tips = new TextView(this);
        tv_tips.setGravity(Gravity.CENTER);
        tv_tips.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        tv_tips.setText("Please use the menu on the toolbar to test.");
        activity_container.addView(tv_tips);
    }

    private void setListener() {
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                switch (item.getItemId()) {
                    case R.id.action_first:
                        switchToActivity("firstbundle", "com.whh.firstbundle.FirstBundleActivity");
//                        intent.setClassName(getBaseContext(), "com.whh.firstbundle.FirstBundleActivity");
//                        startActivity(intent);
                        break;
                    case R.id.action_update:
                        intent.setClassName(getBaseContext(), "com.whh.atlastest.UpdateActivity");
                        startActivity(intent);
                        break;
                    case R.id.action_remote:
                        intent.setClassName(getBaseContext(), "com.whh.remotebundle.RemoteBundleActivity");
                        startActivity(intent);
                        break;
                    case R.id.action_person:
                        intent.setClassName(getBaseContext(), "com.whh.personmanager.PersonCenterActivity");
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }

    public void switchToActivity(String key, String name) {
        Intent intent = new Intent();
        intent.setClassName(getBaseContext(), name);
        activity_delegate.startChildActivity(activity_container, key, intent);
    }
}
