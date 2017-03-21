package com.zj.ipai.ipai.activities;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.zj.ipai.ipai.R;
import com.zj.ipai.ipai.fragments.FirstFragment;
import com.zj.ipai.ipai.utils.Snackbars;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

     @BindView (R.id.mBottomBar)
     BottomBar mBottomBar;
     FragmentTransaction mFragmentTransaction;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          setContentView (R.layout.activity_main);
          super.onCreate (savedInstanceState);
          Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
          setSupportActionBar (toolbar);
          FloatingActionButton fab = (FloatingActionButton) findViewById (R.id.fab);
          fab.setOnClickListener (new View.OnClickListener () {
               @Override
               public void onClick(View view) {
               }
          });
          init ();

     }

     private void init() {
          mFragmentTransaction = getSupportFragmentManager ().beginTransaction ();
          mFragmentTransaction.add (new FirstFragment (), "one");
//          mFragmentTransaction.add (new SecondFragment (),"three");
//          mFragmentTransaction.add (new ThirdFragment (),"two");
          mFragmentTransaction.commit ();
          mFragmentTransaction.show (MainManager.getCurrentFragment ());
          mBottomBar.setOnTabSelectListener (new OnTabSelectListener () {
               @Override
               public void onTabSelected(@IdRes int tabId) {
                    Snackbars.showSnackar (mBottomBar, tabId + "");
//                    mFragmentTransaction.show (MainManager.getCurrentFragment ());
               }
          });
     }

     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
          // Inflate the menu; this adds items to the action bar if it is present.
          getMenuInflater ().inflate (R.menu.menu_main, menu);
          return true;
     }

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
}
