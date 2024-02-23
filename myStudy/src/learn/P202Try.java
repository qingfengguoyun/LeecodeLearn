package learn;

import java.util.*;
import java.util.stream.Collectors;

public class P202Try {

    Map<Integer,Integer> map1=new HashMap<>();
    Map<Integer,Integer> record=new HashMap<>();
    public boolean isHappy(int n) {
        List<Integer> numList=new LinkedList<>();
        for(int i=0;i<10;i++){
            numList.add(i);
        }
        map1=numList.stream().collect(Collectors.toMap(t->t,t->t*t));
        while(record.getOrDefault(n,null)==null){
            char[] chars = String.valueOf(n).toCharArray();
            Integer sum=0;
            for(char c:chars){
                sum+=map1.get((int)(c-48));
            }
            if(sum==1){
                return true;
            }else {
                record.put(n,sum);
                n=sum;
            }
        }
        return record.get(n)==1;
    }

    public static void main(String[] args) {
        P202Try p202Try=new P202Try();
        int n=2;
        System.out.println(p202Try.isHappy(n));
    }
}
