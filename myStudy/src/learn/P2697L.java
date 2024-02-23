package learn;

import java.util.Arrays;

public class P2697L {

    String s=null;

    public String makeSmallestPalindrome(String s) {
        this.s=s;
        char[] chars = s.toCharArray();
        int left=0;
        int right=chars.length-1;
        while(left<=right){
            if (chars[left]!=chars[right]){
                char l=chars[left]<chars[right]?chars[left]:chars[right];
                chars[left]=l;
                chars[right]=l;

            }
            left++;
            right--;
        }
        return String.copyValueOf(chars);
    }

    public static void main(String[] args) {
        P2697L p2697L=new P2697L();
        String str="egcfe";
        System.out.println(p2697L.makeSmallestPalindrome(str));
    }
}
