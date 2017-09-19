package com.whh.commonlib.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * @author mahuafeng
 * @title
 * @description
 * @date 16/5/27
 */

public class DensityUtil {
    public static final String TAG = DensityUtil.class.getSimpleName();

    /**
     * dp转px
     * @param context
     * @param dpValue
     * @return 成功：px值，失败：-1
     */
    public static int dpToPx(Context context, float dpValue){
        if(dpValue <= 0){
            return -1;
        }

        int px = -1;
        final float scale = context.getResources().getDisplayMetrics().density;
        px = (int)(dpValue * scale +0.5f);
        return px;
    }

    /**
     * px转dp
     * @param context
     * @param pxValue
     * @return 成功：dp的值，失败：-1
     */
    public static int pxTodp(Context context, float pxValue){
        if(pxValue < 0){
            return -1;
        }

        int dp = -1;
        final float scale = context.getResources().getDisplayMetrics().density;
        dp = (int)(pxValue/scale + 0.5f);
        return dp;
    }

    /**
     * 获取屏幕的宽度
     * @param context
     * @return 成功：屏幕宽度，失败：-1
     */
    public static int getScreenWidth(Context context){
        int screenWidth = -1;
        //获取窗口管理
        WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        //另一种方法:WindowManager windowManager = ((Activity)context).getWindowManager();
        //DisplayMetrics 提供显示通用信息的类：字体，分辨率等
        DisplayMetrics displayMetrics = new DisplayMetrics();
        //将窗口信息存放到displayMetrics里面
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        //返回屏幕宽度
        screenWidth = displayMetrics.widthPixels;
        return screenWidth;
    }
}
