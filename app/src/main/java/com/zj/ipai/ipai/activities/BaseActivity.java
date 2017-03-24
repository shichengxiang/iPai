package com.zj.ipai.ipai.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.zj.ipai.ipai.R;

import butterknife.ButterKnife;

/**
 * name of class: iPai
 * creater: scx
 * time: 2017/3/21 18:26
 */

public abstract class BaseActivity extends AppCompatActivity {
     @Override
     protected void onCreate(@Nullable Bundle savedInstanceState) {
          super.onCreate (savedInstanceState);
          setContentView (getLayout ());
          ButterKnife.bind (this);
          initView (savedInstanceState);
     }

     public abstract void initView(@Nullable Bundle saveInstanceState);
     public abstract int getLayout();

}
