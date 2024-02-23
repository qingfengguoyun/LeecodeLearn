package learn;

import java.util.Arrays;
import java.util.OptionalInt;

public class P1671L {
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

    public static int[] reverseSubarray(int[] arr, int i, int j) {
        // 创建新的数组，长度为 j-i+1
        int[] reversedArr = new int[j - i + 1];

        // 反转区间数据并存储到新数组
        for (int k = i; k <= j; k++) {
            reversedArr[k - i] = arr[j - (k - i)];
        }

        // 返回新数组
        return reversedArr;
    }
    public static int[] getSubarray(int[] arr, int i, int j) {
        // 计算区间长度
        int length = j - i + 1;

        // 创建新的数组
        int[] subarray = new int[length];

        // 复制区间数据到新数组
        for (int k = 0; k < length; k++) {
            subarray[k] = arr[i + k];
        }
        // 返回新数组
        return subarray;
    }

    public int minimumMountainRemovals(int[] nums){
        //找数组中的某个最大值

        int maxValue= Arrays.stream(nums).max().getAsInt();
        int maxIndex=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==maxValue){
                maxIndex=i;
                break;
            }
        }
        //对左侧求以该位置结尾的最长递增子序列
        int[] leftArray = getSubarray(nums, 0, maxIndex);
        int[] rightArray = reverseSubarray(nums, maxIndex, nums.length - 1);
        int l1 = lengthOfLIS(leftArray);
        int l2=lengthOfLIS(rightArray);
        return nums.length-(l1+l2-1);

        //对右侧反转，求以该位置结尾的最长递增子序列

    }

    public static void main(String[] args) {
        int[] nums={9,8,1,7,6,5,4,3,2,1};
        P1671L p1671L=new P1671L();
        int i = p1671L.minimumMountainRemovals(nums);
        System.out.println(i);
    }
}
