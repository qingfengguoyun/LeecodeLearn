package learn;

import java.util.*;

public class P219Try {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> recordMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(recordMap.getOrDefault(nums[i],null)==null){
                List<Integer> list=new LinkedList<>();
                list.add(i);
                recordMap.put(nums[i],list);
            }else{
                recordMap.get(nums[i]).add(i);
            }
        }
        for(Map.Entry<Integer,List<Integer>> entry:recordMap.entrySet()){
            List<Integer> list = entry.getValue();
            for(int i=0;i<list.size()-1;i++){
                if(Math.abs(list.get(i+1)-list.get(i))<=k){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        P219Try p219Try=new P219Try();
        int[] arrays={1,2,3,1};
        int k=3;
        boolean b = p219Try.containsNearbyDuplicate(arrays, k);
        System.out.println(b);

    }
}
