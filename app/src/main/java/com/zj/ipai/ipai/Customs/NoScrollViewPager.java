package com.zj.ipai.ipai.customs;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * name of class: iPai
 * creater: scx
 * time: 2017/3/22 14:16
 */

public class NoScrollViewPager extends ViewPager {
     public NoScrollViewPager(Context context) {
          super (context);
     }

     public NoScrollViewPager(Context context, AttributeSet attrs) {
          super (context, attrs);
     }

     @Override
     public boolean onTouchEvent(MotionEvent ev) {
          return false;
     }
}
