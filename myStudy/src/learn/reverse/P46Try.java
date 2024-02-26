package learn.reverse;

import java.util.*;
import java.util.stream.Collectors;

public class P46Try {

    List<List<Integer>> res=new LinkedList<>();
    Map<Integer,Boolean> map=new HashMap();

    public void initMap(int[] nums){
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],false);
        }
    }

    public List<List<Integer>> fun(List<Integer> term,int [] nums){
        if(term.size()==nums.length){
            res.add(term.stream().collect(Collectors.toList()));
        }else{
            for(int i=0;i<nums.length;i++){
                Integer j=nums[i];
//                System.out.println(map.get(j));
                if(map.get(j)==false){
                    term.add(j);
                    map.put(j,true);
                    fun(term,nums);
                    map.put(j,false);
                    term.remove(term.size()-1);
                }
            }
        }
        return res;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> term=new LinkedList<>();
        initMap(nums);
        List<List<Integer>> res = fun(term, nums);
        return  res;

    }

    public static void main(String[] args) {
        P46Try p46Try=new P46Try();

        int[] nums=new int[]{1,2,3};
//        p46Try.initMap(nums);
        List<List<Integer>> res = p46Try.permute(nums);
        res.stream().forEach(t->{
            t.stream().forEach(t2->{
                System.out.print(t2+" ");
            });
            System.out.println();
        });
    }
}
