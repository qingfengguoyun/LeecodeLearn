package learn.reverse;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P47Try2 {
    List<List<Integer>> res=new LinkedList<>();
    Map<Integer,Integer> map=new HashMap();
    List<List<Integer>> snapshot=new LinkedList<>();

    public void initMap(int[] nums){
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
    }

    public List<List<Integer>> fun(List<Integer> term,int [] nums){
        if(term.size()==nums.length){
            res.add(term.stream().collect(Collectors.toList()));
        }else{
            snapshot.add(term);
            for(int i=0;i<nums.length;i++){
                Integer j=nums[i];
//                System.out.println(map.get(j));
                if(map.get(j)>0){
                    term.add(j);
                    map.put(j,map.get(j)-1);
                    fun(term,nums);
                    map.put(j,map.get(j)+1);
                    term.remove(term.size()-1);
                }
            }
        }
        return res;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> term=new LinkedList<>();
        initMap(nums);
        List<List<Integer>> res = fun(term, nums);
//        List<List<Integer>> collect = res.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
        return  res;
    }
}
