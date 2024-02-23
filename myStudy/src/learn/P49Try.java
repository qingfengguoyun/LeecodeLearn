package learn;

import java.util.*;
import java.util.stream.Collectors;

public class P49Try {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> collect = Arrays.stream(strs).map(str -> {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }).collect(Collectors.toList());
        Map<String,List<Integer>> record=new HashMap<>();
        int i=0;
        for(i=0;i<collect.size();i++){
            String s = collect.get(i);
            if(!record.containsKey(s)){
                LinkedList<Integer> list = new LinkedList<Integer>();
                list.add(i);
                record.put(s,list);
            }else{
                List<Integer> list = record.get(s);
                list.add(i);
            }
        }
        List<List<String>>result=new LinkedList<>();
        record.entrySet().stream().forEach(t->{
            List<Integer> list = t.getValue();
            List<String> strList = list.stream().map(index -> {
                return strs[index];
            }).collect(Collectors.toList());
            result.add(strList);
        });

        return result;
    }

    public static void main(String[] args) {
        P49Try p49Try=new P49Try();
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = p49Try.groupAnagrams(strs);
        lists.stream().forEach(list->{
            list.stream().forEach(t-> System.out.print(t+" "));
            System.out.println();
        });
    }
}
