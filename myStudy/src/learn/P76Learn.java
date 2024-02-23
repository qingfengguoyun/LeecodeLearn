package learn;

import java.util.HashMap;
import java.util.Map;

public class P76Learn {


    public Map getCountMap(String t){
        Map<Character,Integer> tokenMap=new HashMap<>();
        for(Character c:t.toCharArray()){
            if(!tokenMap.containsKey(c)){
                tokenMap.put(c,1);
            }else{
                tokenMap.put(c,tokenMap.get(c)+1);
            }
        }
        return tokenMap;
    }
    public Boolean compareMap(Map<Character,Integer> checkMap,Map<Character,Integer> tarMap){
        for(Map.Entry<Character,Integer> entry:tarMap.entrySet()){
            if(!checkMap.containsKey(entry.getKey())){
                return false;
            }
            if(checkMap.getOrDefault(entry.getKey(),0)<entry.getValue()){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        if(t.equals("")){
            return "";
        }
        Map<Character,Integer> tokenMap=getCountMap(t);
        Map<Character,Integer> countMap=new HashMap<>();
        Integer left=0,right=0;
        Integer ansLeft=0,ansRight=0;
        Integer len=s.length()+1;
        while(right<s.length()){
            countMap.put(s.charAt(right),countMap.getOrDefault(s.charAt(right),0)+1);
            //当前子串包含全部token字符时，开始移动左侧指针
            if(compareMap(countMap,tokenMap)){
                while(compareMap(countMap,tokenMap)){
                    countMap.put(s.charAt(left),countMap.get(s.charAt(left))-1);
                    left+=1;
                }
                left-=1;
                Integer termLen=right-left+1;
                if(termLen<len){
                    ansLeft=left;
                    ansRight=right;
                    len=termLen;
                }
                left+=1;
            }
            right+=1;
        }
        if(len!=s.length()+1){
            return s.substring(ansLeft,ansRight+1);
        }else {
            return "";
        }
    }

    public static void main(String[] args) {
        P76Learn p76Learn=new P76Learn();
//        String s="ADOBECODEBANC";
//        String t="ABC";
        String s="a";
        String t="aa";
        System.out.println(p76Learn.minWindow(s,t));
    }
}
