package com.zj.ipai.ipai.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zj.ipai.ipai.R;

/**
 * name of class: iPai
 * creater: scx
 * time: 2017/3/21 17:53
 */

public class FirstFragment extends BaseFragment {

     @Nullable
     @Override
     public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          View rootView = inflater.inflate (R.layout.fragment_first, container,false);
          return rootView;
     }
}
