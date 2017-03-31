package com.zj.ipai.ipai.Customs;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * name of class: iPai
 * creater: scx
 * time: 2017/3/29 11:16
 */

public class PopupWindw extends PopupWindow {

     private static Builder sBuilder;

     private View contentView;
     public PopupWindw(Context context,View layout){
          super(context);
          contentView= layout;
          this.setContentView (contentView);
          this.setWidth (ViewGroup.LayoutParams.MATCH_PARENT);
          this.setHeight (ViewGroup.LayoutParams.MATCH_PARENT);//全屏
          this.setFocusable (true);//弹窗可点击
          // 实例化一个ColorDrawable颜色为半透明
          ColorDrawable dw = new ColorDrawable(0xb0000000);
          // 设置弹出窗体的背景
          this.setBackgroundDrawable(dw);
          // 设置弹出窗体显示时的动画，从底部向上弹出
//          this.setAnimationStyle(R.style.take_photo_anim);
     }
     private static class Builder{
          public String name;
          public static Builder setBackGroundColor(){
               sBuilder.name="";
               return sBuilder;
          }
     }
     public static Builder builder(){
          sBuilder=new Builder ();
          return sBuilder;
     }
}
