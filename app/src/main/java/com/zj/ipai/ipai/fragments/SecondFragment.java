package com.zj.ipai.ipai.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zj.ipai.ipai.R;
import com.zj.ipai.ipai.utils.Snackbars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * name of class: iPai
 * creater: scx
 * time: 2017/3/21 17:53
 */

public class SecondFragment extends BaseFragment {

     private Context mContext;
     @BindView (R.id.nav_tabLayout)
     TabLayout mTabLayout;
     @BindView (R.id.viewPager)
     ViewPager mViewPager;
     @BindView (R.id.refreshLayout)
     SwipeRefreshLayout mRefreshLayout;
//     @BindView (R.id.recyclerView)
//     RecyclerView mRecyclerView;

     @Nullable
     @Override
     public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          View contentView = inflater.inflate (R.layout.fragment_second, container, false);
          ButterKnife.bind (this, contentView);
          return contentView;
     }

     @Override
     public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
          super.onViewCreated (view, savedInstanceState);
          initData ();
          initView ();
     }

     @Override
     public void onAttach(Context context) {
          super.onAttach (context);
          mContext = context;
     }

     private void initView() {
          View tab = LayoutInflater.from (mContext).inflate (R.layout.item_tab, null);
//          mTabLayout.addTab (mTabLayout.newTab ().setText ("推荐").setIcon (ContextCompat.getDrawable (mContext, R.drawable.near_me)), true);
//          mTabLayout.addTab (mTabLayout.newTab ().setText ("衣服").setIcon (ContextCompat.getDrawable (mContext,R.drawable.near_me)));
//          TextView txt = (TextView) tab.findViewById (R.id.tabTxt);
//          txt.setText ("美食");
//          mTabLayout.addTab (mTabLayout.newTab ().setCustomView (tab));
          mTabLayout.addOnTabSelectedListener (new TabLayout.OnTabSelectedListener () {
               @Override
               public void onTabSelected(TabLayout.Tab tab) {
//                    Snackbars.showSnackar (mTabLayout, "点击啦 ！" + tab.getPosition ());
               }

               @Override
               public void onTabUnselected(TabLayout.Tab tab) {
               }

               @Override
               public void onTabReselected(TabLayout.Tab tab) {
               }
          });
          SecondAdapter secondAdapter = new SecondAdapter ();
          secondAdapter.setData (getContext (), Arrays.asList ("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
          mViewPager.setAdapter (secondAdapter);
          mTabLayout.setupWithViewPager (mViewPager);
          setupRefresh ();
     }

     private void initData() {
     }

     /**
      * 下拉刷新控件
      */
     private void setupRefresh() {
          mRefreshLayout.setColorSchemeColors (Color.parseColor ("#423611"));
          mRefreshLayout.setOnRefreshListener (new SwipeRefreshLayout.OnRefreshListener () {
               @Override
               public void onRefresh() {
                    new Handler ().postDelayed (new Runnable () {
                         @Override
                         public void run() {
                              mRefreshLayout.setRefreshing (false);
                         }
                    }, 2000);
               }
          });
//          mRecyclerView.setAdapter ();
     }

     private class SecondAdapter extends PagerAdapter {
          String[] titles = {"推荐", "衣服", "美食"};
          List<View> mViewList;

          public void setData(Context context, List<String> l) {
               mViewList = new ArrayList<> ();
               if (l != null) {
                    for (String s : l) {
                         ImageView iv = new ImageView (context);
                         iv.setLayoutParams (new ViewGroup.LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                         mViewList.add (iv);
                    }
               }
          }

          @Override
          public int getCount() {
               return mViewList.size ();
          }

          @Override
          public boolean isViewFromObject(View view, Object object) {
               return view instanceof Object;
          }

          @Override
          public Object instantiateItem(ViewGroup container, int position) {
               container.addView (mViewList.get (position));
               return mViewList.get (position);
          }

          @Override
          public void destroyItem(ViewGroup container, int position, Object object) {
               container.removeView (mViewList.get (position));
          }

          @Override
          public CharSequence getPageTitle(int position) {
               return titles[position % 3];
          }
     }
}
