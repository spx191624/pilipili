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

    public static String getTime(int shijian){
        int h = shijian/3600;
        int m = shijian%3600/60;
        int s = shijian%60;
        String x = "";
        if (h>=1){
            x+= h +":";
        }
        if (m>9){
            x+= m +":";
        }else{
            x+= "0"+m +":";
        }
        if (s>9){
            x+= s ;
        }else{
            x+= "0"+s ;
        }
        return x;
    }

}
