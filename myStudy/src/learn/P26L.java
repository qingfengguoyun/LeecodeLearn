package learn;

import java.util.Arrays;

public class P26L {

    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=1;
        while(i<nums.length&&j< nums.length){
            if(nums[i]!=nums[j]){
                nums[i+1]=nums[j];
                i++;
            }else{
                j++;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums={0,0,1,1,1,2,2,3,3,4};
        P26L p26L=new P26L();
        int k = p26L.removeDuplicates(nums);
        System.out.println(k);
        for(int i=0;i<k;i++){
            System.out.println(nums[i]);
        }
    }
}
