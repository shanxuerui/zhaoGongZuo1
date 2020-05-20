package Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Author:单雪瑞
 * 2020/3/6 19:35
 */
public class Test01 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        map.put("单雪瑞", "三牛");
        map.put("单雪松", "胖娃");
        map.put("单雪飞", "龙龙");

        Set<Map.Entry<String, String>> entries = map.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey()+entry.getValue());
        }

        long l = System.currentTimeMillis();
        System.out.println(l);

        System.out.println("15");

    }
}
