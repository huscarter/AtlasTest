package com.whh.atlastest;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.taobao.atlas.bundleInfo.AtlasBundleInfoManager;
import android.taobao.atlas.framework.Atlas;
import android.taobao.atlas.runtime.ActivityTaskMgr;
import android.taobao.atlas.runtime.ClassNotFoundInterceptorCallback;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import org.osgi.framework.BundleException;

import java.io.File;

/**
 * @author huscarter
 * @title
 * @description
 * @date 2017/05/31
 */
public class MyApplication extends Application {
    private static final String TAG = MyApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate");
        super.onCreate();

        Atlas.getInstance().setClassNotFoundInterceptorCallback(new ClassNotFoundInterceptorCallback() {
            @Override
            public Intent returnIntent(Intent intent) {
                final String className = intent.getComponent().getClassName();
                final String bundleName = AtlasBundleInfoManager.instance().getBundleForComponet(className);

                Log.i(TAG, "returnIntent className:" + className + ",bundleName:" + bundleName);

                if (!TextUtils.isEmpty(bundleName) && !AtlasBundleInfoManager.instance().isInternalBundle(bundleName)) {
                    //远程bundle
                    Activity activity = ActivityTaskMgr.getInstance().peekTopActivity();
                    File remoteBundleFile = new File(activity.getExternalCacheDir(), "lib" + bundleName.replace(".", "_") + ".so");
                    Log.i(TAG, "remoteBundleFile:" + remoteBundleFile);
                    String path = "";
                    if (remoteBundleFile.exists()) {
                        path = remoteBundleFile.getAbsolutePath();
                        Log.i(TAG, "remoteBundleFile path:" + path);
                    } else {
                        Toast.makeText(activity, " 远程bundle不存在，请确定 : " + remoteBundleFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
                        return intent;
                    }


                    PackageInfo info = activity.getPackageManager().getPackageArchiveInfo(path, 0);
                    try {
                        Atlas.getInstance().installBundle(info.packageName, new File(path));
                    } catch (BundleException e) {
                        Toast.makeText(activity, " 远程bundle 安装失败，" + e.getMessage(), Toast.LENGTH_LONG).show();

                        e.printStackTrace();
                    }

                    activity.startActivities(new Intent[]{intent});

                }

                return intent;
            }
        });

    }
}
