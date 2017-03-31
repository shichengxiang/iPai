package com.zj.ipai.ipai.Entity;

/**
 * name of class: iPai
 * creater: scx
 * time: 2017/3/31 11:35
 */

public class IpaiImg {
     private String url;
     private String name;
     private float heightScale;
     private float widthScale;

     public float getWidthScale() {
          return widthScale;
     }

     public void setWidthScale(float widthScale) {
          this.widthScale = widthScale;
     }

     public float getHeightScale() {
          return heightScale;
     }

     public void setHeightScale(float heightScale) {
          this.heightScale = heightScale;
     }

     public boolean isChecked() {
          return isChecked;
     }

     public void setChecked(boolean checked) {
          isChecked = checked;
     }

     private boolean isChecked;

     public String getUrl() {
          return url;
     }

     public void setUrl(String url) {
          this.url = url;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }
}
