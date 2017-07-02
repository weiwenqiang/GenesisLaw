package com.wwq.genesislaw.controller.utils;

import android.content.Context;
import android.util.TypedValue;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by 魏文强 on 2016/11/14.
 * 常用单位转换的辅助类
 */
public class DensityUtils {
    private DensityUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * dp转px
     *
     * @param context
     * @return
     */
    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }
    /**
     * sp转px
     *
     * @param context
     * @return
     */
    public static int sp2px(Context context, float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, context.getResources().getDisplayMetrics());
    }

    /**
     * px转dp
     *
     * @param context
     * @param pxVal
     * @return
     */
    public static float px2dp(Context context, float pxVal) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (pxVal / scale);
    }

    /**
     * px转sp
     *
     * @param pxVal
     * @return
     */
    public static float px2sp(Context context, float pxVal) {
        return (pxVal / context.getResources().getDisplayMetrics().scaledDensity);
    }

    public static String getRounding(double cost) {
        BigDecimal bigDecimal = new BigDecimal(cost);
        BigDecimal total = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String format = decimalFormat.format(total);
        return format;
    }

    public static double getRounding2(String cost) {
        BigDecimal bigDecimal = new BigDecimal(Double.valueOf(cost));
        BigDecimal total = bigDecimal.setScale(2, BigDecimal.ROUND_DOWN);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String format = decimalFormat.format(total);
        return Double.valueOf(format);
    }
}
