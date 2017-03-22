package nataya.pilipili.utils;

/**
 * Created by 191624 on 2017/3/22.
 */

public class NumUtils {
    public static String getNum(int number){
        String s ="";
        if (number>10000){
            s += number/10000 +"."+ number%10000/1000 +"万";
        }else{
            s += number;
        }
        return s;
    }

}
