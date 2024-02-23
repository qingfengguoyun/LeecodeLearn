package learn;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class P383Try {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] rChars = ransomNote.toCharArray();
        char[] mChars = magazine.toCharArray();
        Arrays.sort(rChars);
        Arrays.sort(mChars);
        int r=0,m=0;
        while(r<rChars.length){
            if(m>=mChars.length){
                return false;
            }
            if(rChars[r]==mChars[m]){
                r++;m++;
            }else{
                m++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P383Try p383Try=new P383Try();
        String r="aa";
        String m="aab";
        System.out.println(p383Try.canConstruct(r,m));
    }
}
