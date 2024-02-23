package learn;

import java.util.Arrays;

public class P151Try {
    public String reverseWords(String s) {
        s=s.trim();
        String[] s1 = s.split("\\s+");
        System.out.println(s1.length);
        Arrays.stream(s1).forEach(t-> System.out.println(t.length()));
        StringBuilder builder=new StringBuilder();
        for(int i=s1.length-1;i>=0;i--){
            builder.append(s1[i]+" ");
        }
        int length=builder.length();
        for(int j=builder.length()-1;j>=0;j--){
            if(builder.charAt(j)==' '){
                    length--;
                }else{
                break;
            }
        }
        builder.setLength(length);
        return builder.toString();
    }

    public static void main(String[] args) {
        String s="  hello world  ";
        P151Try p151Try=new P151Try();
        String str = p151Try.reverseWords(s);
        System.out.println(str);
    }
}
