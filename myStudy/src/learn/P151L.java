package learn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P151L {
    public String reverseWords(String s){
        s=s.trim();
        String[] s1 = s.split("\\s+");
        List<String> collect = Arrays.stream(s1).collect(Collectors.toList());
        Collections.reverse(collect);
        return String.join(" ",collect);
    }

    public static void main(String[] args) {
        String s="  hello world  ";
        P151L p151L=new P151L();
        String s1 = p151L.reverseWords(s);
        System.out.println(s1);
    }
}
