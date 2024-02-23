package learn;

import java.util.Arrays;

public class P45Try {

    public int jump(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,99999);
        dp[0]=0;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if((i-j)<=nums[j]){
                    dp[i]=dp[i]<dp[j]+1?dp[i]:dp[j]+1;
                }
            }
        }
        for(int i: dp){
            System.out.println(i);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        P45Try p45Try=new P45Try();
        int[] nums={2,3,1,1,4};
        int jump = p45Try.jump(nums);
        System.out.println(jump);
    }
}
