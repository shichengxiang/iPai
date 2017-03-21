package com.zj.ipai.ipai;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
     @Test
     public void addition_isCorrect() throws Exception {
          assertEquals (4, 2 + 2);
     }

     @Test
     public void generateDimens() {
          gen ();
     }

     public static void gen() {
          File file = new File ("D:\\workplaces/studio_xwch/iPai/app/src/main/res/values/dimens.xml");
          BufferedReader reader = null;
          StringBuilder mdpi = new StringBuilder ();
          StringBuilder hdpi = new StringBuilder ();
          StringBuilder xdpi = new StringBuilder ();
          StringBuilder xxdpi = new StringBuilder ();
          StringBuilder xxxdpi = new StringBuilder ();
          try {
               System.out.println ("生成不同分辨率：");
               reader = new BufferedReader (new FileReader (file));
               String tempString;
               int line = 1;
               // 一次读入一行，直到读入null为文件结束
               while ((tempString = reader.readLine ()) != null) {
                    if (tempString.contains ("</dimen>")) {
                         //tempString = tempString.replaceAll(" ", "");
                         String start = tempString.substring (0, tempString.indexOf (">") + 1);
                         String end = tempString.substring (tempString.lastIndexOf ("<") - 2);
                         int num = Integer.valueOf (tempString.substring (tempString.indexOf (">") + 1, tempString.indexOf ("</dimen>") - 2));
                         mdpi.append (start).append (new BigDecimal (num).multiply (new BigDecimal (2)).divide (new BigDecimal (4)).setScale (1, BigDecimal.ROUND_HALF_UP).toString ()).append (end).append ("\n");
                         hdpi.append (start).append (new BigDecimal (num).multiply (new BigDecimal (3)).divide (new BigDecimal (4)).setScale (1, BigDecimal.ROUND_HALF_UP).toString ()).append (end).append ("\n");
                         xdpi.append (start).append (new BigDecimal (num).multiply (new BigDecimal (1)).setScale (1, BigDecimal.ROUND_HALF_UP).toString ()).append (end).append ("\n");
                         xxdpi.append (start).append (new BigDecimal (num).multiply (new BigDecimal (6)).divide (new BigDecimal (4)).setScale (1, BigDecimal.ROUND_HALF_UP).toString ()).append (end).append ("\n");
                         xxxdpi.append (start).append (new BigDecimal (num).multiply (new BigDecimal (2)).setScale (1, BigDecimal.ROUND_HALF_UP).toString ()).append (end).append ("\n");

                    } else {
                         mdpi.append (tempString).append ("\n");
                         hdpi.append (tempString).append ("\n");
                         xdpi.append (tempString).append ("\n");
                         xxdpi.append (tempString).append ("\n");
                         xxxdpi.append (tempString).append ("\n");
                    }
                    line++;
               }
               reader.close ();
               String mdpif = "D:\\workplaces/values-mdpi/dimens.xml";
               String hdpif = "D:\\workplaces/values-hdpi/dimens.xml";
               String xdpif = "D:\\workplaces/values-xdpi/dimens.xml";
               String xxdpif = "D:\\workplaces/values-xxdpi/dimens.xml";
               String xxxdpif = "D:\\workplaces/values-xxxdpi/dimens.xml";
               writeFile (mdpif, mdpi.toString ());
               writeFile (hdpif, hdpi.toString ());
               writeFile (xdpif, xdpi.toString ());
               writeFile (xxdpif, xxdpi.toString ());
               writeFile (xxxdpif, xxxdpi.toString ());
          } catch (IOException e) {
               e.printStackTrace ();
          } finally {
               if (reader != null) {
                    try {
                         reader.close ();
                    } catch (IOException e1) {
                         e1.printStackTrace ();
                    }
               }
          }
     }

     public static void writeFile(String file, String text) {
          PrintWriter out = null;
          File create = new File (file);
          if (!create.exists ())
               try {
                    create.getParentFile ().mkdir ();
               } catch (Exception e) {
                    e.printStackTrace ();
               }
          try {
               out = new PrintWriter (new BufferedWriter (new FileWriter (file)));
               out.write (text);
          } catch (IOException e) {
               e.printStackTrace ();
          } finally {
               out.close ();
          }
     }
}