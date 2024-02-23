package learn;

import java.util.HashMap;
import java.util.Map;

public class P205Try {

    public boolean check(String s,String t){
        Map<Character,Character> record=new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character sc=Character.valueOf(s.charAt(i));
            Character tc=Character.valueOf(t.charAt(i));
            Character sc1 = record.getOrDefault(sc, null);
            if(sc1==null){
                record.put(sc,tc);
            }else{
                if(!sc1.equals(tc)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isIsomorphic(String s, String t) {
        return check(s,t)&&check(t,s);
    }

    public static void main(String[] args) {
        P205Try p205Try=new P205Try();
        String s="badc";
        String t="baba";
        boolean isomorphic = p205Try.isIsomorphic(s, t);
        System.out.println(isomorphic);
    }
}
