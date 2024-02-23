package learn;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class P290Try {
    public boolean wordPattern(String pattern, String s) {

        Map<Character,String> map=new HashMap<>();
        char[] chars = pattern.toCharArray();
        String[] strs = s.split(" ");
        if(chars.length!=strs.length){
            return false;
        }
        for(int i=0;i<chars.length;i++){
            if(map.containsKey(chars[i])){
                if(!map.get(chars[i]).equals(strs[i])){
                    return false;
                }
            }else{
                map.put(chars[i],strs[i]);
            }
        }
        Set<String> collect = map.entrySet().stream().map(t -> t.getValue()).collect(Collectors.toSet());
        if(collect.size()!=map.size()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        P290Try p290Try=new P290Try();
        String pattern="abba";
        String s="dog cat cat dog";

        System.out.println(p290Try.wordPattern(pattern,s));
    }
}
