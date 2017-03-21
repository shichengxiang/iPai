package com.zj.ipai.ipai.utils;

import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.zj.ipai.ipai.R;

/**
 * name of class: iPai
 * creater: scx
 * time: 2017/3/21 13:27
 */

public class Snackbars {
     private static Snackbar sSnackbar;

     public static void showSnackar(View view, String content) {
          sSnackbar = Snackbar.make (view, content, Snackbar.LENGTH_SHORT);
          sSnackbar.show ();

     }

     public static void showSnack(View view, String content, String action, View.OnClickListener listener) {
          sSnackbar.make (view, content, Snackbar.LENGTH_LONG).setAction (action, listener);
          sSnackbar.show ();
     }

     /**
      * 背景，字颜色
      * @param msgColor
      * @param bgColor
      */
     public static void setBackGroundColor(int msgColor, int bgColor) {
          View view = sSnackbar.getView ();
          view.setBackgroundColor (bgColor);
          ((TextView) view.findViewById (R.id.snackbar_text)).setTextColor (msgColor);
     }
     public static void setLeftImg(int img){
          View view=sSnackbar.getView ();
          Snackbar.SnackbarLayout layout= (Snackbar.SnackbarLayout) view;
          View view_add= LayoutInflater.from (sSnackbar.getContext ()).inflate (R.layout.space_item_view,null);
          layout.addView (view_add,0);
     }
}
