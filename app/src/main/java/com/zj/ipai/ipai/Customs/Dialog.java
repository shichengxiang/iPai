package com.zj.ipai.ipai.Customs;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.animation.Animation;

import com.zj.ipai.ipai.utils.Animations;

/**
 * name of class: iPai
 * creater: scx
 * time: 2017/3/29 16:45
 */

public class Dialog {
     private Dialog() {
     }

     private static AlertDialog mAlertDialog;
     private static View mWindow;
     private static Animation inAnim;
     private static Animation outAnim;

     public static AlertDialog create(Context context, View view, boolean isOutSide) {
          mAlertDialog = new AlertDialog.Builder (context).create ();
          mAlertDialog.setCancelable (true);
          mAlertDialog.setCanceledOnTouchOutside (isOutSide);
          mAlertDialog.setView (view);
          mWindow = mAlertDialog.getWindow ().getDecorView ().findViewById (android.R.id.content);
          inAnim = Animations.getDialogInAnimation (context);
          outAnim = Animations.getDialogOutAnimation (context);
          return mAlertDialog;
     }

     public static void show() {
          mWindow.startAnimation (inAnim);
          mAlertDialog.show ();
     }

     public static void dismiss() {
          mWindow.startAnimation (outAnim);
          mAlertDialog.dismiss ();
          clearAnim ();
     }

     private static void clearAnim() {
          mWindow.clearAnimation ();
          mWindow = null;
     }
     public static boolean isShowing(){
          if(mAlertDialog==null)
               return false;
          return mAlertDialog.isShowing ();
     }
}
