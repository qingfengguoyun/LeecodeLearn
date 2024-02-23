package learn;

import java.util.Arrays;

public class P300Try {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=1;
        for(int i=0;i<nums.length;i++){
            int max=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    max=max>=(dp[j]+1)?max:dp[j]+1;
                }
            }
            dp[i]=max;
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        P300Try p300Try=new P300Try();
        int[] nums={1,3,6,7,9,4,10,5,6};
        int i = p300Try.lengthOfLIS(nums);
        System.out.println(i);
    }
}
