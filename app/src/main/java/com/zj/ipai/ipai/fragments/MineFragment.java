package com.zj.ipai.ipai.fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.zj.ipai.ipai.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * name of class: iPai
 * creater: scx
 * time: 2017/3/29 13:53
 */

public class MineFragment extends BaseFragment {
     @BindView (R.id.mAppBarLayout)
     AppBarLayout mAppBarLayout;
     @BindView (R.id.mToolbarLayout)
     CollapsingToolbarLayout mToolbarLayout;
     @BindView (R.id.more)
     View mView_more;
     private PopupWindow mPopupWindow;

     @Nullable
     @Override
     public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          View view = inflater.inflate (R.layout.fragment_mine, container, false);
          ButterKnife.bind (this, view);
          return view;
     }

     @Override
     public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
          super.onViewCreated (view, savedInstanceState);
          initView ();
     }

     private void initView() {
          mAppBarLayout.setExpanded (false);
          mToolbarLayout.setTitle ("陈妍希");
          mToolbarLayout.setExpandedTitleColor (Color.parseColor ("#451547"));
          new Handler ().postDelayed (new Runnable () {
               @Override
               public void run() {
                    mAppBarLayout.setExpanded (true);
               }
          }, 4000);
     }

     @OnClick ({R.id.more})
     public void onClick(View view) {
          switch (view.getId ()) {
               case R.id.more:
                    displayMoreMenu ();
                    break;
          }
     }

     private void displayMoreMenu() {
          if (mPopupWindow == null) {
               View view = LayoutInflater.from (getContext ()).inflate (R.layout.item_tab, null);
               mPopupWindow = new PopupWindow (getContext ());
               mPopupWindow.setTouchable (true);
               mPopupWindow.setOutsideTouchable (true);
               mPopupWindow.setBackgroundDrawable (new ColorDrawable (Color.parseColor ("#bb000000")));
               mPopupWindow.setContentView (view);

          }
          if (!mPopupWindow.isShowing ())
               mPopupWindow.showAsDropDown (mView_more,0, (int) (12*getResources ().getDisplayMetrics ().density));
     }
}
