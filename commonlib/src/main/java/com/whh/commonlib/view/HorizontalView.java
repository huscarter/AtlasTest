package com.whh.commonlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.whh.commonlib.R;
import com.whh.commonlib.utils.DensityUtil;

/**
 * @author mahuafeng
 * @title 单条view显示 从左往右一次是imageview-textview-textview-imageview
 * @description
 * @date 16/12/19
 */


public class HorizontalView extends RelativeLayout {
    private TextView tv_left;
    private TextView tv_right;
    private Context context;

    public HorizontalView(Context context) {
        super(context);
        init(context);
    }

    public HorizontalView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.HorizontalView);
        tv_left.setText(typedArray.getString(R.styleable.HorizontalView_left_text));
        tv_left.setTextSize(DensityUtil.pxTodp(context, typedArray.getDimension(R.styleable.HorizontalView_left_text_size, context.getResources().getDimension(R.dimen.font_size_mid_lib))));
        tv_left.setTextColor(typedArray.getColor(R.styleable.HorizontalView_left_text_color, context.getResources().getColor(R.color.text_black)));
        tv_left.setCompoundDrawablesWithIntrinsicBounds(typedArray.getDrawable(R.styleable.HorizontalView_left_drawable), null, null, null);
        tv_left.setCompoundDrawablePadding(DensityUtil.pxTodp(context, typedArray.getDimension(R.styleable.HorizontalView_left_drawable_paddding, 0)));

        tv_right.setText(typedArray.getString(R.styleable.HorizontalView_right_text));
        tv_right.setTextSize(DensityUtil.pxTodp(context, typedArray.getDimension(R.styleable.HorizontalView_right_text_size, context.getResources().getDimension(R.dimen.font_size_mid_lib))));
        tv_right.setTextColor(typedArray.getColor(R.styleable.HorizontalView_right_text_color, context.getResources().getColor(R.color.text_black)));
        tv_right.setCompoundDrawablesWithIntrinsicBounds(null, null, typedArray.getDrawable(R.styleable.HorizontalView_right_drawable), null);
        tv_right.setCompoundDrawablePadding(DensityUtil.pxTodp(context, typedArray.getDimension(R.styleable.HorizontalView_right_drawable_paddding, 0)));
        typedArray.recycle();
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_horizontal, null);
        tv_left = (TextView) view.findViewById(R.id.tv_left);
        tv_right = (TextView) view.findViewById(R.id.tv_right);

        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(view, layoutParams);
    }

    public TextView getTv_left() {
        return tv_left;
    }

    public void setTv_left(TextView tv_left) {
        this.tv_left = tv_left;
    }

    public TextView getTv_right() {
        return tv_right;
    }

    public void setTv_right(TextView tv_right) {
        this.tv_right = tv_right;
    }

    public void setLeftDrawable(Drawable drawable) {
        tv_left.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
    }

    public void setRightTextValue(String value) {
        tv_right.setText(value);
    }

    public void setRightTextColor(int color){
        tv_right.setTextColor(color);
    }

    public void setLeftTextValue(String value) {
        tv_left.setText(value);
    }
}
