package com.zj.ipai.ipai;

/**
 * name of class: iPai
 * creater: scx
 * time: 2017/3/22 16:52
 */

public class Atest {
     boolean hasCar, hasHouse, hasMoney;

     private void marry() {

          if (hasCar && hasHouse && hasMoney) {
               alert ("娶媳妇去喽！");
          } else if (hasCar || hasHouse || hasMoney) {
               alert ("打扮下，相亲去！");
          } else {
               alert ("该干活了！");
          }

     }

     private void alert(String s) {
     }

}
