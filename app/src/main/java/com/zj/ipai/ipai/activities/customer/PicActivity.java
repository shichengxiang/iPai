package com.zj.ipai.ipai.activities.customer;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.zj.ipai.ipai.Entity.IpaiImg;
import com.zj.ipai.ipai.R;
import com.zj.ipai.ipai.adapter.WaterFallAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PicActivity extends BaseActivity {

     @BindView (R.id.content_pic)
     RecyclerView mRecyclerView;
     @BindView (R.id.tv_pic_next)
     View mPic_next;
     private WaterFallAdapter mWaterFallAdapter;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate (savedInstanceState);
          setContentView (R.layout.activity_pic);
          Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
          setSupportActionBar (toolbar);
          ButterKnife.bind (this);
          init ();
     }

     @Override
     public int getLayout() {
          return R.layout.activity_pic;
     }

     @Override
     public void init() {
          mRecyclerView.setLayoutManager (new StaggeredGridLayoutManager (3, StaggeredGridLayoutManager.VERTICAL));
          mRecyclerView.setItemAnimator (new DefaultItemAnimator ());
          mWaterFallAdapter = new WaterFallAdapter (this);
          mRecyclerView.setAdapter (mWaterFallAdapter);
          mWaterFallAdapter.setData (getImgs ());
          setTitle ("choose");
     }
     //     private void init() {
//
//     }

     private List<IpaiImg> getImgs() {
          List<IpaiImg> result = new ArrayList<> ();
          List<String> list = Arrays.asList ("http://img.my.csdn.net/uploads/201309/01/1378037235_3453.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037235_7476.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037235_9280.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037234_3539.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037234_6318.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037194_2965.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037193_1687.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037193_1286.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037192_8379.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037178_9374.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037177_1254.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037177_6203.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037152_6352.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037151_9565.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037151_7904.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037148_7104.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037129_8825.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037128_5291.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037128_3531.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037127_1085.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037095_7515.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037094_8001.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037093_7168.jpg",
                  "http://img.my.csdn.net/uploads/201309/01/1378037091_4950.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949643_6410.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949642_6939.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949630_4505.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949630_4593.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949629_7309.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949629_8247.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949615_1986.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949614_8482.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949614_3743.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949614_4199.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949599_3416.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949599_5269.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949598_7858.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949598_9982.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949578_2770.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949578_8744.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949577_5210.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949577_1998.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949482_8813.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949481_6577.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949480_4490.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949455_6792.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949455_6345.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949442_4553.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949441_8987.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949441_5454.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949454_6367.jpg",
                  "http://img.my.csdn.net/uploads/201308/31/1377949442_4562.jpg");
          for (int i = 0; i < list.size (); i++) {
               IpaiImg ipai = new IpaiImg ();
               ipai.setUrl (list.get (i));
               ipai.setHeightScale (getRandom ());
               result.add (ipai);
          }
          return result;
     }

     /**
      * get a random that is bigger than 0.5
      *
      * @return
      */
     private float getRandom() {
          float result = (float) Math.random () * 300;
          if (result > 0.5) {
               return result;
          } else {
               getRandom ();
          }
          return result;
     }
     @OnClick({R.id.tv_pic_next})
     public void onClick(View view){
          switch (view.getId ()){
               case R.id.tv_pic_next:
                    break;
          }
     }
}
