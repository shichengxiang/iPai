package com.zj.ipai.ipai.presenter;

/**
 * name of class: iPai
 * creater: scx
 * time: 2017/4/1 14:01
 */

public abstract class BasePresenter<T, V> {
     public T mModel;
     public V mView;

     public BasePresenter(T model, V view) {
          mModel = model;
          mView =view;
     }

     /**
      * 垃圾回收
      */
     public void gc(){
          mModel=null;
          mView=null;
     }
}
