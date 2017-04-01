package com.zj.ipai.ipai.fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.zj.ipai.ipai.customs.PullToZoomScrollView;
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

     @BindView (R.id.zoomScrollView_personal)
     PullToZoomScrollView mZoomScrollView;
     @BindView (R.id.toolbar)
     Toolbar mToolbar;
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
          View zoom = LayoutInflater.from (getContext ()).inflate (R.layout.layout_personal_head, null);
          View contentVeiw = LayoutInflater.from (getContext ()).inflate (R.layout.layout_persona_content, null);
          mZoomScrollView.setHeaderView (LayoutInflater.from (getContext ()).inflate (R.layout.layout_personal_head,null));
          mZoomScrollView.setZoomView (zoom);
          mZoomScrollView.setScrollContentView (contentVeiw);
          mZoomScrollView.setZoomEnabled (true);
          mZoomScrollView.setOnScrollViewChangedListener (new PullToZoomScrollView.OnScrollViewChangedListener () {
               @Override
               public void onInternalScrollChanged(int left, int top, int oldLeft, int oldTop) {
                    float v = Float.parseFloat (top + "");
                    float n = v / 300;
                    mToolbar.setAlpha (n);
               }
          });
          int mScreenWidth = getResources ().getDisplayMetrics ().widthPixels;
          LinearLayout.LayoutParams localObject = new LinearLayout.LayoutParams (
                  mScreenWidth, getResources ().getDisplayMetrics ().heightPixels / 12 * 5);
          mZoomScrollView.setHeaderLayoutParams (localObject);

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
               mPopupWindow.showAsDropDown (mView_more, 0, (int) (12 * getResources ().getDisplayMetrics ().density));
     }
}
