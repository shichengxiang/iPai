package com.zj.ipai.ipai.activities;

import android.support.v4.app.Fragment;

import com.zj.ipai.ipai.fragments.BaseFragment;
import com.zj.ipai.ipai.fragments.FirstFragment;
import com.zj.ipai.ipai.fragments.SecondFragment;
import com.zj.ipai.ipai.fragments.ThirdFragment;

/**
 * name of class: iPai
 * creater: scx
 * time: 2017/3/21 17:40
 */

public class MainManager {
     private static BaseFragment firstFragment,secondFragment,thirdFragment;

     public enum Type {
          FIRST, SECOND, THIRD
     }

     private static BaseFragment mCurrentFragment = null;

     public static Fragment getFragment(Type tag) {
          switch (tag) {
               case FIRST:
                    if(firstFragment==null)
                         mCurrentFragment=firstFragment=new FirstFragment ();
                    mCurrentFragment=firstFragment;
                    break;
               case SECOND:
                    if(secondFragment==null)
                         secondFragment=new SecondFragment ();
                    mCurrentFragment=secondFragment;
                    break;
               case THIRD:
                    if(thirdFragment==null)
                         thirdFragment=new ThirdFragment ();
                    mCurrentFragment=thirdFragment;
                    break;
          }
          return mCurrentFragment;
     }

     public static Fragment getCurrentFragment() {
          return mCurrentFragment;
     }
}
