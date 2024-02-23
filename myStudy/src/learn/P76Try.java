package learn;

import java.util.*;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 */
public class P76Try {
    Integer i = 1;
    public String minWindow(String s, String t) {
        char[] chars = t.toCharArray();
        Set<Character> tokens=new HashSet<>();
        for(char c:chars){
            tokens.add(c);
        }
        Map<Character, Integer[]>indexMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!indexMap.containsKey(s.charAt(i))){
                Integer[] array=new Integer[2];
                array[0]=i;
                array[1]=i;
                indexMap.put(s.charAt(i),array);
            }else{
                Integer[] array= indexMap.get(s.charAt(i));
                array[1]=i;
            }
        }
        //
        Set<Character> sChars = indexMap.keySet();
        if(!sChars.containsAll(tokens)){
            return "";
        }
//        Integer left=s.length();
//        Integer right=0;
//        for(Map.Entry entry:indexMap.entrySet()){
//            if(tokens.contains(entry.getKey())){
//                Integer[] value =(Integer[]) entry.getValue();
//                right=right>=value[0]?right:value[0];
//                left=left<=value[1]?left:value[1];
//            }
//        }
//        if(left<=right){
//            return s.substring(left,right);
//        }
        return "";
    }

    public static void main(String[] args) {
        P76Try p76Try=new P76Try();
        String s="ADOBECODEBANC";
        String t="ABC";
        System.out.println(p76Try.minWindow(s,t));
    }
}
