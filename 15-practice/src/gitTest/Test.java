package gitTest;

import java.math.BigDecimal;

/**
 * Author:单雪瑞
 * 2020/2/29 20:52
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("三牛");
             System.out.println("憨牛");
                System.out.println("酸牛");
           System.out.println("大雪");
             System.out.println("二雪");

             Double a = 0.1;
             String b = "0.1";

        Double aDouble = Double.valueOf(b);
        String string = Double.toString(a);
        BigDecimal bigDecimal = new BigDecimal(a);
        System.out.println(bigDecimal);
        BigDecimal bigDecimal1 = new BigDecimal(b);
        System.out.println(b);
    }

}
