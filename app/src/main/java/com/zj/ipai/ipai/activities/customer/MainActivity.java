package com.zj.ipai.ipai.activities.customer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.zj.ipai.ipai.Customs.BottomBar;
import com.zj.ipai.ipai.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * name of class: iPai
 * creater: scx
 * time: 2017/3/23 13:45
 */

public class MainActivity extends AppCompatActivity {

     @BindView (R.id.bottomBar)
     BottomBar mBottomBar;
     @Override
     protected void onCreate(@Nullable Bundle savedInstanceState) {
          super.onCreate (savedInstanceState);
          setContentView (R.layout.activity_cusotmer_main);
          Toolbar toolbar= (Toolbar) findViewById (R.id.toolbar);
          setSupportActionBar (toolbar);
          ButterKnife.bind (this);
          mBottomBar.setLayout (R.layout.bottombar, new BottomBar.OnTabChangedListener () {
               @Override
               public void onTabSelected(int position) {
               }

               @Override
               public boolean onIntercept(int position) {
                    return false;
               }
          });
     }

//     private void initSearch(){
//          mSearchView.setOnClickListener (new View.OnClickListener () {
//               @Override
//               public void onClick(View v) {
//                    mSearchView.showSearch (true);
//               }
//          });
//          mSearchView.setOnQueryTextListener (new MaterialSearchView.OnQueryTextListener () {
//               @Override
//               public boolean onQueryTextSubmit(String query) {
//                    return false;
//               }
//
//               @Override
//               public boolean onQueryTextChange(String newText) {
//                    return false;
//               }
//          });
//          mSearchView.setOnSearchViewListener (new MaterialSearchView.SearchViewListener () {
//               @Override
//               public void onSearchViewShown() {
//               }
//
//               @Override
//               public void onSearchViewClosed() {
//               }
//          });
//          mSearchView.setSuggestions (new String[]{"1","2"});
//     }
}
