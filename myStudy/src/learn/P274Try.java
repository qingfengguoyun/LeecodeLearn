package learn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class P274Try {

    class MyCompare implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1>o2?-1:1;
        }
    }

//    public int hIndex(int[] citations) {
//        //降序排序
//        Integer[] nums=Arrays.stream(citations).boxed().toArray(Integer[]::new);
//        Arrays.sort(nums,new MyCompare());
////        Arrays.stream(nums).forEach(System.out::println );
//        int i=0;
//        int left=0,right=nums.length-1;
//        while(left<right){
//            int mid=(left+right)/2+1;
//            if(nums[mid]<mid+1){
//                right=mid-1;
//            }
//            else{
//                left=mid;
//            }
//        }
//        //比较时没有比过nums[0]的位置
//        if(left==0){
//            return nums[left]>=1?1:0;
//        }
//        return left+1;
//    }

    public int hIndex(int[] citations) {
        //降序排序
        Integer[] nums=Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(nums,new MyCompare());
//        Arrays.stream(nums).forEach(System.out::println );
        int i=0;
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=(left+right)/2+1;
            if(nums[mid]>=mid+1){
                left=mid;
            }
            else{
                right=mid-1;
            }
        }
        //比较时没有比过nums[0]的位置
        if(left==0){
            return nums[left]>=1?1:0;
        }
        return left+1;
    }


    public static void main(String[] args) {
        P274Try p274Try=new P274Try();
        int[] citations=new int[]{6,5,3,1,0};
        int i = p274Try.hIndex(citations);
        System.out.println(i);;
    }
}
