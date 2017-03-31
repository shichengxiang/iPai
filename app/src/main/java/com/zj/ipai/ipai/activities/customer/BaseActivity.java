package com.zj.ipai.ipai.activities.customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.zj.ipai.ipai.R;

import butterknife.ButterKnife;

/**
 * name of class: iPai
 * creater: scx
 * time: 2017/3/31 13:53
 */

public abstract class BaseActivity extends AppCompatActivity {

     private TextView mTitle;
     @Override
     protected void onCreate(@Nullable Bundle savedInstanceState) {
          super.onCreate (savedInstanceState);
          setContentView (getLayout ());
          ButterKnife.bind (this);
          Toolbar toolbar= ButterKnife.findById (this,R.id.toolbar);
          mTitle= (TextView) toolbar.findViewById (R.id.title);
          setSupportActionBar (toolbar);
          init ();
     }
     public abstract int getLayout();
     public abstract void init();

     @Override
     public void startActivity(Intent intent) {
          super.startActivity (intent);
     }

     @Override
     public void startActivityForResult(Intent intent, int requestCode) {
          super.startActivityForResult (intent, requestCode);
     }
     public void setTitle(String title){
          getSupportActionBar ().setDisplayShowTitleEnabled (false);
          mTitle.setText (title);
     }
}
