package learn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P1Try {

    class Data{
        Integer value;
        Integer index;

        public Data(Integer value, Integer index) {
            this.value = value;
            this.index = index;
        }

        public Integer getValue() {
            return value;
        }

        public Integer getIndex() {
            return index;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        List<Data> collect = IntStream.range(0, nums.length).boxed().map(t -> {
            return new Data(nums[t], t);
        }).sorted((t1, t2) -> {
            return t1.value - t2.value;
        }).collect(Collectors.toList());
        int left=0,right=nums.length-1;
        while(left<right){
            if(collect.get(left).getValue()+collect.get(right).getValue()==target){
                return new int[]{collect.get(left).getIndex(),collect.get(right).getIndex()};
            }
            if(collect.get(left).getValue()+collect.get(right).getValue()<target){
                left+=1;
            }else{
                right-=1;
            }
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        int[] nums=new int[]{2,7,11,15};
        int target=9;
        P1Try p1Try=new P1Try();
        int[] ints = p1Try.twoSum(nums, target);
        System.out.println(ints[0]+" "+ints[1]);
    }
}
