package com.zj.ipai.ipai.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zj.ipai.ipai.R;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * name of class: iPai
 * creater: scx
 * time: 2017/3/21 17:53
 */

public class FirstFragment extends BaseFragment {
     private AppCompatActivity mActivity;
     //     @BindView (R.id.app_bar)
//     AppBarLayout mAppBarLayout;
//     @BindView (R.id.home_content)
//     View home_content;
//     @BindView (R.id.progressbar)
//     ProgressBar mProgressBar;
//     @BindView (R.id.toolbar)
//     Toolbar mToolbar;
//     @BindView (R.id.toolbar_layout)
//     CollapsingToolbarLayout mCollapsingToolbarLayout;
//     @BindView (R.id.fab) View fab;
     @BindView (R.id.banner)
     Banner mBanner;
     @BindView (R.id.tabs_chooseType)
     TabLayout mTabLayout;

     @Nullable
     @Override
     public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          View rootView = inflater.inflate (R.layout.fragment_first, container, false);
          ButterKnife.bind (this, rootView);
          return rootView;
     }

     @Override
     public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
          super.onViewCreated (view, savedInstanceState);
          mActivity= (AppCompatActivity) getActivity ();
          initView ();
     }

     private void initView() {
          Toolbar toolbar= (Toolbar) mActivity.findViewById (R.id.toolbar1);
          mActivity.setSupportActionBar (toolbar);
          initBanenr ();
          initTabLayout ();
//          mAppBarLayout.setExpanded (false);
//          mProgressBar.setVisibility (View.VISIBLE);
//          home_content.setVisibility (View.INVISIBLE);
//          new Handler ().postDelayed (new Runnable () {
//               @Override
//               public void run() {
//                    mAppBarLayout.setExpanded (true);
//                    Animation animation= AnimationUtils.loadAnimation (getActivity (),R.anim.pop_up_in);
//                    home_content.startAnimation (animation);
//                    home_content.setVisibility (View.VISIBLE);
//                    mProgressBar.setVisibility (View.GONE);
//               }
//          },2500);
//          mCollapsingToolbarLayout.setTitle ("你好！ ~");
//          mCollapsingToolbarLayout.setExpandedTitleColor (Color.parseColor ("#ff000000"));
//
//          fab.setOnClickListener (new View.OnClickListener () {
//               @Override
//               public void onClick(View v) {
//                    if(mDialog==null){
//                         View view=LayoutInflater.from (getContext ()).inflate (R.layout.item_tab,null);
//                        mDialog= Dialog.create (getContext (),view,true);
//                    }
//                    if(!mDialog.isShowing ())
//                         mDialog.show ();
//               }
//          });
     }

     /**
      * 轮播
      */
     private void initBanenr() {
          List<String> imgUrls = Arrays.asList ("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491386972&di=885a5f67614308f5fb99ed079259c44b&imgtype=jpg&er=1&src=http%3A%2F%2Ffile28.mafengwo.net%2FM00%2F5F%2F71%2FwKgB6lQH-NOAGAPGABaQOIFArE029.jpeg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490792252683&di=7c5f4b478e6d00823a05a0593ecc8716&imgtype=0&src=http%3A%2F%2Fimage98.360doc.com%2FDownloadImg%2F2016%2F07%2F0614%2F75410530_3.jpg");
          mBanner.setBannerStyle (BannerConfig.CIRCLE_INDICATOR)
                  .setIndicatorGravity (Gravity.CENTER)
                  .setImages (imgUrls).setImageLoader (new GlideImageLoader ()).start ();
     }

     public class GlideImageLoader extends ImageLoader{

          @Override
          public void displayImage(Context context, Object path, ImageView imageView) {
               Glide.with (context).load (path).centerCrop ().into (imageView);
          }

     }

     /**
      * 初始化tablayout
      */
     private void initTabLayout(){
          mTabLayout.addTab (mTabLayout.newTab ().setText ("风格"),0,true);
          mTabLayout.addTab (mTabLayout.newTab ().setText ("季节"),1,false);
          mTabLayout.addTab (mTabLayout.newTab ().setText ("色彩"),2,false);
     }
}
