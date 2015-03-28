package xorj;

import java.util.Random;

/**
 *
 * @author crashdemons <crashdemons -at- github.com>
 */
public class Common {
    public static Random rand=new Random();
    public static long stol(String s){
        try{ return Long.valueOf(s); }catch(Exception e){ return 0l; }
    }
    public static int stoi(String s){
        try{ return Integer.parseInt(s); }catch(Exception e){ return 0; }
    }
}
