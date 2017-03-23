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
     private static BaseFragment firstFragment, secondFragment, thirdFragment;

     public enum Type {
          FIRST, SECOND, THIRD
     }

     private MainManager() {
     }

     public static Fragment newInstance(int position) {
          switch (position) {
               case 0:
                    if (firstFragment == null)
                         firstFragment = new FirstFragment ();
                    return firstFragment;
               case 1:
                    if(secondFragment==null)
                         secondFragment=new SecondFragment ();
                    return secondFragment;
               case 2:
                    if(thirdFragment==null)
                         thirdFragment=new ThirdFragment ();
                    return thirdFragment;
          }
          return null;
     }
}
