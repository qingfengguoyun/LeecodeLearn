package learn;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class P15Try2 {

    int i=0;
    int l=0;
    int r=0;

    public List<List<Integer>> threeSum(int[] nums){
        int[] nums2=nums.clone();
        Arrays.sort(nums);
        Set<List<Integer>> resList=new HashSet<>();



        for(i=0;i<nums.length-1;i++){
            if(nums[i]>0){
                break;
            }
            else{
                l=i+1;
                r=nums.length-1;
                int tar=0-nums[i];
                while(l<r){
                    if(nums[l]+nums[r]==tar){
                        LinkedList<Integer> list = new LinkedList<Integer>() {{
                            add(nums[i]);
                            add(nums[l]);
                            add(nums[r]);
                        }};
                        resList.add(list);
                        l++;
                    }
                    else if(nums[l]+nums[r]<tar){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        List<List<Integer>> res = resList.stream().collect(Collectors.toList());
        return res;
    }

    public static void main(String[] args) {
        P15Try2 p15Try2=new P15Try2();
        int[] nums={-1,0,1,2,-1,-4};
        List<List<Integer>> lists = p15Try2.threeSum(nums);
        lists.stream().forEach(t->{
            t.stream().forEach(t2->{
                System.out.print(t2+" ");
            });
            System.out.println();
        });
    }
}
