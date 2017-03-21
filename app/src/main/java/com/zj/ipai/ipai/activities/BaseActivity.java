package com.zj.ipai.ipai.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * name of class: iPai
 * creater: scx
 * time: 2017/3/21 18:26
 */

public class BaseActivity extends AppCompatActivity {
     @Override
     protected void onCreate(@Nullable Bundle savedInstanceState) {
          super.onCreate (savedInstanceState);
          ButterKnife.bind (this);
     }
}
