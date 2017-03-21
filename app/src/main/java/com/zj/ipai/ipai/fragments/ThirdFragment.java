package com.zj.ipai.ipai.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zj.ipai.ipai.R;

import butterknife.ButterKnife;

/**
 * name of class: iPai
 * creater: scx
 * time: 2017/3/21 17:53
 */

public class ThirdFragment extends BaseFragment {

     @Nullable
     @Override
     public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          View contentView=inflater.inflate (R.layout.fragment_third,container);
          ButterKnife.bind (contentView);
          return contentView;
     }
}
