package com.zj.ipai.ipai.activities;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;

import com.zj.ipai.ipai.Customs.BottomBar;
import com.zj.ipai.ipai.R;
import com.zj.ipai.ipai.fragments.BaseFragment;
import com.zj.ipai.ipai.fragments.FirstFragment;
import com.zj.ipai.ipai.fragments.SecondFragment;
import com.zj.ipai.ipai.fragments.ThirdFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements SearchView.OnQueryTextListener {

     @NonNull
     @BindView (R.id.bottomBar)
     BottomBar mBottomBar;
//     @BindView (R.id.bottom_nav)
//     BottomNavigationView mBottomNavigationView;

     private String[] tags = {"one", "two", "three"};
     private int curIndex = 0;

     private FragmentManager mManager;
     private Fragment curFragment;
     private BaseFragment fragment1, fragment2, fragment3;

     @Override
     public int getLayout() {
          return R.layout.activity_main;
     }

     @Override
     public void initView(Bundle saveInstanceState) {
          init (saveInstanceState);
     }

     private void init(Bundle bundle) {
          initFragmentUI (bundle);
//          initViewPager ();
//          mBottomBar.setOnTabSelectListener (new OnTabSelectListener () {
//               @Override
//               public void onTabSelected(@IdRes int tabId) {
//                    switchFragment (curIndex, getPositionById (tabId));
//               }
//          });
          mBottomBar.setLayout (R.layout.bottombar, new BottomBar.OnTabChangedListener () {
               @Override
               public void onTabSelected(int position) {
                    switchFragment (curIndex,position);
               }

               @Override
               public boolean onIntercept(int position) {
                    return false;
               }
          });
//          mBottomNavigationView.setOnNavigationItemSelectedListener (new BottomNavigationView.OnNavigationItemSelectedListener () {
//               @Override
//               public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    switchFragment (curIndex,getPositionById (item.getItemId ()));
//                    return false;
//               }
//          });
     }

     /**
      * init operate of fragment UI
      *
      * @param bundle
      */
     private void initFragmentUI(Bundle bundle) {
          if (mManager == null | bundle == null) {//第一次
               curFragment = newInstance (0);
               mManager = getSupportFragmentManager ();
               FragmentTransaction mTransaction = mManager.beginTransaction ();
               mTransaction.add (R.id.contentContainer, newInstance (0), tags[0])
                       .add (R.id.contentContainer, newInstance (1), tags[1])
                       .add (R.id.contentContainer, newInstance (2), tags[2]).hide (newInstance (1)).hide (newInstance (2)).show (curFragment).commit ();
          } else {//多次
               curFragment = mManager.getFragment (bundle, tags[curIndex]);
               hideOtherFragment (curIndex);
          }
     }

     private void switchFragment(int cur, int des) {
          if (cur != des) {
               hideOtherFragment (des);
               curIndex = des;
          }
     }

//     @Override
//     public boolean onCreateOptionsMenu(Menu menu) {
//          // Inflate the menu; this adds items to the action bar if it is present.
//          getMenuInflater ().inflate (R.menu.menu_main, menu);
//          return true;
//     }

     @Override
     public boolean onOptionsItemSelected(MenuItem item) {
          // Handle action bar item clicks here. The action bar will
          // automatically handle clicks on the Home/Up button, so long
          // as you specify a parent activity in AndroidManifest.xml.
          int id = item.getItemId ();
          //noinspection SimplifiableIfStatement
          if (id == R.id.action_settings) {
               return true;
          }
          return super.onOptionsItemSelected (item);
     }

     @Override
     protected void onSaveInstanceState(Bundle outState) {
          super.onSaveInstanceState (outState);

     }

     @Override
     public boolean onQueryTextSubmit(String query) {
          return false;
     }

     @Override
     public boolean onQueryTextChange(String newText) {
          if(isLongTime ()){
               //TODO goto request
          }
          return false;
     }
     private long lastTime=0;

     /**
      * 输入慢于1s 网络请求
      * @return
      */
     private boolean isLongTime(){
          long cur = System.currentTimeMillis ();
          if(Math.abs (cur-lastTime)>1500){
               lastTime=cur;
               return true;
          }
          lastTime=cur;
          return false;
     }

     private static class SessionAdapter extends FragmentPagerAdapter {

          public SessionAdapter(FragmentManager fm) {
               super (fm);
          }

          @Override
          public Fragment getItem(int position) {
               BaseFragment fragment = null;
               switch (position) {
                    case 0:
                         fragment = new FirstFragment ();
                         break;
                    case 1:
                         fragment = new SecondFragment ();
                         break;
                    case 2:
                         fragment = new ThirdFragment ();
                         break;
               }
               return fragment;
          }

          @Override
          public int getCount() {
               return 3;
          }
     }

     private int getPositionById(@IdRes int id) {
          switch (id) {
               case R.id.tab_favorites:
                    return 0;
               case R.id.tab_nearby:
                    return 1;
               case R.id.tab_friends:
                    return 2;
          }
          return 0;
     }

     private Fragment newInstance(int p) {
          switch (p) {
               case 0:
                    if (fragment1 == null)
                         fragment1 = new FirstFragment ();
                    return fragment1;
               case 1:
                    if (fragment2 == null)
                         fragment2 = new SecondFragment ();
                    return fragment2;
               case 2:
                    if (fragment3 == null)
                         fragment3 = new ThirdFragment ();
                    return fragment3;
          }
          return new FirstFragment ();
     }

     private void hideOtherFragment(int showIndex) {
          FragmentTransaction transaction = mManager.beginTransaction ();
          for (int i = 0; i < tags.length; i++) {
               if (showIndex == i) {
                    transaction.show (newInstance (showIndex));
               } else {
                    transaction.hide (newInstance (i));
               }
          }
          transaction.commit ();
     }

}
