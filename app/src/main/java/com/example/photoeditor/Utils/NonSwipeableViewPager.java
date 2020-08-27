package com.example.photoeditor.Utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.ScrollView;
import android.widget.Scroller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import java.lang.reflect.Field;

public class NonSwipeableViewPager extends ViewPager {

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    public NonSwipeableViewPager(@NonNull Context context) {
        super(context);
        setMyScroller();
    }

    private void setMyScroller() {

        try {
            Class<?> viewager = ViewPager.class;
            Field scroller = viewager.getDeclaredField("mScroller");
            scroller.setAccessible(true);
            scroller.set(this,new MyScroller(getContext()));
        }
        catch (NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
        }
    }

    public NonSwipeableViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setMyScroller();
    }

    private class MyScroller  extends Scroller {

        public MyScroller(Context context) {
            super(context , new DecelerateInterpolator());
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration ) {
            super.startScroll(startX, startY, dx, dy ,400);
        }
    }
}
