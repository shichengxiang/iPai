package com.zj.ipai.ipai.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.signature.StringSignature;
import com.zj.ipai.ipai.Entity.IpaiImg;
import com.zj.ipai.ipai.R;

import java.util.ArrayList;
import java.util.List;

/**
 * name of class: babyIyo-master
 * creater: scx
 * time: 2017/3/31 11:30
 */

public class WaterFallAdapter extends RecyclerView.Adapter<WaterFallAdapter.WaterViewHolder> {

     public WaterFallAdapter(Context context) {
          this.mContext = context;
     }

     private Context mContext;
     private List<IpaiImg> mImgs = new ArrayList<> ();

     public void setData(List<IpaiImg> list) {
          if (list != null)
               mImgs = list;
          notifyDataSetChanged ();
     }

     @Override
     public WaterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
          View itemView = LayoutInflater.from (parent.getContext ()).inflate (R.layout.item_ipaiimg, parent, false);
          return new WaterViewHolder (itemView);
     }

     @Override
     public void onBindViewHolder(WaterViewHolder holder, final int position) {
          Glide.with (mContext).load (mImgs.get (position).getUrl ()).signature (new StringSignature ("001")).into (holder.iv);
          ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams ();
          layoutParams.height = (int) mImgs.get (position).getHeightScale ();
          holder.mCheckBox.setChecked (mImgs.get (position).isChecked ());
          holder.mCheckBox.setOnClickListener (new View.OnClickListener () {
               @Override
               public void onClick(View v) {
                    mImgs.get (position).setChecked (((CheckBox)v).isChecked ());
               }
          });
     }

     @Override
     public int getItemCount() {
          return mImgs.size ();
     }

     class WaterViewHolder extends RecyclerView.ViewHolder {

          ImageView iv;
          CheckBox mCheckBox;

          public WaterViewHolder(View itemView) {
               super (itemView);
               iv = (ImageView) itemView.findViewById (R.id.iv_img);
               mCheckBox = (CheckBox) itemView.findViewById (R.id.cb_checked);
          }
     }
}
