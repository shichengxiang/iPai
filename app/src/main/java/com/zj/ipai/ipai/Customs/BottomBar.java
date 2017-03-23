package com.zj.ipai.ipai.Customs;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.zj.ipai.ipai.R;

import java.util.ArrayList;
import java.util.List;

/**
 * name of class: iPai
 * creater: scx
 * time: 2017/3/23 17:44
 */

public class BottomBar extends RelativeLayout {
     Context mContext;
     int size = 3;
     List<Item> items = new ArrayList<> ();
     private OnTabChangedListener mListener;
     static int curIndex = 0;

     public BottomBar(Context context) {
          super (context);
          mContext = context;
     }

     public BottomBar(Context context, AttributeSet attrs) {
          super (context, attrs);
          this.mContext = context;
     }

     private void init() {
     }

     public void setLayout(@LayoutRes int layout, OnTabChangedListener lisener) {
          ViewGroup.LayoutParams params=new ViewGroup.LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
          setLayoutParams (params);
          View inflate = LayoutInflater.from (mContext).inflate (layout, null);
          if (items == null)
               items = new ArrayList<> ();
          items.clear ();
          for (int i = 0; i < size; i++) {
               items.add (new Item ());
          }
          items.get (0).parent = inflate.findViewById (R.id.tab1);
          items.get (1).parent = inflate.findViewById (R.id.tab2);
          items.get (2).parent = inflate.findViewById (R.id.tab3);
          items.get (0).iv = inflate.findViewById (R.id.iv_b1);
          items.get (1).iv = inflate.findViewById (R.id.iv_b2);
          items.get (2).iv = inflate.findViewById (R.id.iv_b3);
          items.get (0).tv = inflate.findViewById (R.id.tv_b1);
          items.get (1).tv = inflate.findViewById (R.id.tv_b2);
          items.get (2).tv = inflate.findViewById (R.id.tv_b3);
          this.mListener = lisener;
          setListener ();

     }

     private void setListener() {
          for (int i = 0; i < size; i++) {
               final int index = i;
               items.get (i).parent.setOnClickListener (new OnClickListener () {
                    @Override
                    public void onClick(View v) {
                         changeState (index);
                    }
               });
          }
     }

     private void changeState(int choosed) {
          if (curIndex == choosed) {
               return;
          }
          if (mListener != null & mListener.onIntercept (choosed))
               return;
          if (mListener != null)
               mListener.onTabSelected (choosed);
          for (int i = 0; i < size; i++) {
               if (choosed == i) {
                    items.get (i).parent.setSelected (true);
                    items.get (i).iv.setSelected (true);
                    items.get (i).tv.setSelected (true);
               } else {
                    items.get (i).parent.setSelected (false);
                    items.get (i).iv.setSelected (false);
                    items.get (i).tv.setSelected (false);
               }
          }
          curIndex = choosed;
     }

     private class Item {
          public int id;
          public View parent, iv, tv, w3;
     }

     public interface OnTabChangedListener {
          void onTabSelected(int position);

          boolean onIntercept(int position);
     }
}
