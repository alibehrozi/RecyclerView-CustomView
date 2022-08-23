package com.example.customview.utilities;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;


public class ViewUtils {

    public static int spToPx(float sp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }

    public static int dpToPx(float dp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static void addRipple(Context context, TypedValue typedValue, View view) {
        context.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true);
        view.setBackgroundResource(typedValue.resourceId);
    }

    public static void addCircleRipple(Context context, TypedValue typedValue, View view) {
        context.getTheme().resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, typedValue, true);
        view.setBackgroundResource(typedValue.resourceId);
    }
}
