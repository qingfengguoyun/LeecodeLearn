package learn;

import java.util.*;
import java.util.stream.Collectors;

public class P128Try {

    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toSet()).stream().collect(Collectors.toList());
        Collections.sort(list);
        int max=1,left=0,right=0;
        while(left<list.size()&&right<list.size()){
            if(right==left){
                right++;
            }
            else if(list.get(right-1)==list.get(right)-1){
                max=max>(right-left+1)?max:(right-left+1);
                right+=1;
            }else{
                left=right;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        P128Try p128Try=new P128Try();
        int[] nums={100,4,200,1,3,2};
        int i = p128Try.longestConsecutive(nums);
        System.out.println(i);
    }
}
