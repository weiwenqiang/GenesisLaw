package com.wwq.genesislaw.controller.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.wwq.genesislaw.R;
import com.wwq.genesislaw.view.base.BaseApplication;
import com.wwq.genesislaw.view.layout.Flowlayout;

import java.util.List;
import java.util.Random;

/**
 * Created by 001 on 2017/2/22.
 */

public class UiUtils {
    public static String[] getStringArray(int array_id) {
        return getResource().getStringArray(array_id);
    }

    public static Resources getResource() {
        return BaseApplication.getApplication().getResources();
    }

    public static Context getContext() {
        return BaseApplication.getApplication();
    }

    /**
     * dip转换px
     */
    public static int dip2px(int dip) {
        final float scale = getResource().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /**
     * pxz转换dip
     */

    public static int px2dip(int px) {
        final float scale = getResource().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    /**
     * 方法提交主线程运行
     *
     * @param runnable
     */
    public static void runOnUiThread(Runnable runnable) {
        if (Thread.currentThread().getId() == BaseApplication.getMainTid()) {
            runnable.run();
        } else {
            BaseApplication.getHandler().post(runnable);
        }
    }

    public static View inflate(int id) {
        return View.inflate(getContext(), id, null);
    }

    public static Drawable getDrawalbe(int id) {
        return getResource().getDrawable(id);
    }

    public static float getDimens(int homePictureHeight) {
        return getResource().getDimension(homePictureHeight);
    }

    //延迟执行当前方法
    public static void postDelayed(Runnable runnable, int time) {
        BaseApplication.getHandler().postDelayed(runnable, time);
    }

    //取消任务
    public static void cancel(Runnable runnable) {
        BaseApplication.getHandler().removeCallbacks(runnable);
    }

    //通过反射获取状态栏高度，默认25dp
    public static int getStatusBarHeight(Context context) {
        int statusBarHeight = dip2px(25);
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusBarHeight;
    }

    public static ScrollView getStreamLayout(List<String> data){
        ScrollView scrollView = new ScrollView(UiUtils.getContext());
        scrollView.setBackgroundResource(R.drawable.grid_item_bg_normal);
        Flowlayout layout = new Flowlayout(BaseApplication.getApplication());
        int padding = UiUtils.dip2px(13);
        layout.setPadding(padding, padding, padding, padding);
        //layout.setOrientation(LinearLayout.VERTICAL);// 设置线性布局的方向
        int backColor = 0xffcecece;
        Drawable pressedDrawable = DrawableUtil.createShape(backColor);// 按下显示的图片
        for (int i = 0; i < data.size(); i++) {
            TextView textView = new TextView(UiUtils.getContext());
            final String str = data.get(i);
            textView.setText(str);

            Random random = new Random();   //创建随机
            int red = random.nextInt(200) + 22;
            int green = random.nextInt(200) + 22;
            int blue = random.nextInt(200) + 22;
            int color = Color.rgb(red, green, blue);//范围 0-255
            GradientDrawable createShape = DrawableUtil.createShape(color); // 默认显示的图片
            StateListDrawable createSelectorDrawable = DrawableUtil.createSelectorDrawable(pressedDrawable, createShape);// 创建状态选择器
            textView.setBackgroundDrawable(createSelectorDrawable);
            textView.setTextColor(Color.WHITE);
            //textView.setTextSize(UiUtils.dip2px(14));
            int textPaddingV = UiUtils.dip2px(4);
            int textPaddingH = UiUtils.dip2px(7);
            textView.setPadding(textPaddingH, textPaddingV, textPaddingH, textPaddingV); //设置padding
            textView.setClickable(true);//设置textView可以被点击
            textView.setOnClickListener(new View.OnClickListener() {  // 设置点击事件

                @Override
                public void onClick(View v) {
                    Toast.makeText(UiUtils.getContext(), str, Toast.LENGTH_SHORT).show();
                }
            });
            layout.addView(textView, new LinearLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, -2));// -2 包裹内容
        }
        scrollView.addView(layout);
        return scrollView;
    }

    public static ScrollView getEllipseStreamLayout(List<String> data){
        ScrollView scrollView = new ScrollView(UiUtils.getContext());
        scrollView.setBackgroundResource(R.drawable.grid_item_bg_normal);
        Flowlayout layout = new Flowlayout(BaseApplication.getApplication());
//        int padding = UiUtils.dip2px(13);
        layout.setPadding(0, 5, 0, 5);
        //layout.setOrientation(LinearLayout.VERTICAL);// 设置线性布局的方向
        int backColor = 0xffcecece;
        Drawable pressedDrawable = DrawableUtil.createShape(backColor);// 按下显示的图片
        for (int i = 0; i < data.size(); i++) {
            TextView textView = new TextView(UiUtils.getContext());
            final String str = data.get(i);
            textView.setText(str);

            int color = Color.rgb(246, 96, 31);//范围 0-255
            GradientDrawable createShape = DrawableUtil.createShape(color); // 默认显示的图片
            StateListDrawable createSelectorDrawable = DrawableUtil.createSelectorDrawable(pressedDrawable, createShape);// 创建状态选择器
//            textView.setBackgroundDrawable(createSelectorDrawable);
            textView.setBackgroundResource(R.drawable.ic_action_ellipse);
            textView.setTextColor(color);
            textView.setTextSize(UiUtils.dip2px(7));
            int textPaddingV = UiUtils.dip2px(2);
            int textPaddingH = UiUtils.dip2px(5);
            textView.setPadding(textPaddingH, textPaddingV, textPaddingH, textPaddingV); //设置padding
//            textView.setClickable(true);//设置textView可以被点击
//            textView.setOnClickListener(new View.OnClickListener() {  // 设置点击事件
//
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(UiUtils.getContext(), str, Toast.LENGTH_SHORT).show();
//                }
//            });
            layout.addView(textView, new LinearLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, -2));// -2 包裹内容
        }
        scrollView.addView(layout);
        return scrollView;
    }
}
