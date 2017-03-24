package com.zj.ipai.ipai.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;

import com.miguelcatalan.materialsearchview.utils.AnimationUtil;
import com.zj.ipai.ipai.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * name of class: iPai
 * creater: scx
 * time: 2017/3/21 17:53
 */

public class FirstFragment extends BaseFragment {
     @BindView (R.id.app_bar)
     AppBarLayout mAppBarLayout;
     @BindView (R.id.home_content)
     View home_content;
     @BindView (R.id.progressbar)
     ProgressBar mProgressBar;
     @BindView (R.id.toolbar)
     Toolbar mToolbar;
     @BindView (R.id.toolbar_layout)
     CollapsingToolbarLayout mCollapsingToolbarLayout;

     @Nullable
     @Override
     public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          View rootView = inflater.inflate (R.layout.fragment_first, container,false);
          ButterKnife.bind (this,rootView);
          return rootView;
     }

     @Override
     public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
          super.onViewCreated (view, savedInstanceState);
          initView ();
     }
     private void initView(){
          mAppBarLayout.setExpanded (false);
          mProgressBar.setVisibility (View.VISIBLE);
          home_content.setVisibility (View.INVISIBLE);
          new Handler ().postDelayed (new Runnable () {
               @Override
               public void run() {
                    mAppBarLayout.setExpanded (true);
                    Animation animation= AnimationUtils.loadAnimation (getActivity (),R.anim.pop_up_in);
                    home_content.startAnimation (animation);
                    home_content.setVisibility (View.VISIBLE);
                    mProgressBar.setVisibility (View.GONE);
               }
          },2500);
          mCollapsingToolbarLayout.setTitle ("你好！ ~");
          mCollapsingToolbarLayout.setExpandedTitleColor (Color.parseColor ("#ff000000"));

     }
}
