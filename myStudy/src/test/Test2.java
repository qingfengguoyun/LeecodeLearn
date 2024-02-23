package test;

import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {
        String reg=".*Element";
        String name="Development1553Message";
        System.out.println(Pattern.matches(reg,name));
    }
}
