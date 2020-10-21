package com.example.presentshopping.utils.tool.unit;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.example.presentshopping.config.base.MyApplication;

/**
 * 获取屏幕的宽高
 */

public final class DimenUtil {

    public static int getScreenWidth() {
        final Resources resources = MyApplication.getContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = MyApplication.getContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
