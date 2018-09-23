package com.github.crashdemons.xorj;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author crashdemons <crashdemons -at- github.com>
 */
public class Common {
    public static Random rand=new Random();
    public static void msgbox(int type,String title, String text){
        JOptionPane.showMessageDialog(null, text, title, type);
    }
    public static long stol(String s){
        try{ return Long.valueOf(s); }catch(Exception e){ return 0l; }
    }
    public static int stoi(String s){
        try{ return Integer.parseInt(s); }catch(Exception e){ return 0; }
    }
}
