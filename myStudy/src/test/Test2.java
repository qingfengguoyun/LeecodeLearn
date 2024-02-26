package test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {
//        String reg=".*Element";
////        String name="Development1553Message";
////        System.out.println(Pattern.matches(reg,name));
        Map<Integer,Boolean>map= new HashMap<>();
        map.put(1,false);
        System.out.println(map.get(1));
    }
}
