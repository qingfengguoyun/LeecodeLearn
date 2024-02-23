package learn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P1671Try {
    public int minimumMountainRemovals(int[] nums) {

        if(nums.length<=2){
            return 0;
        }

//        //先移除左侧下降趋势的数和右侧上升趋势的数
//        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
//        for()
        //先找左侧和右侧的两个谷底

        int[] leftMax=new int[nums.length];
        int[] rightMax=new int[nums.length];
        int lmax=0;
        leftMax[0]=lmax;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>lmax){
                lmax=nums[i-1];
                leftMax[i]=nums[i-1];
            }else{
                leftMax[i]=lmax;
            }
        }

        int rmax=0;
        rightMax[nums.length-1]=rmax;
        for(int j=nums.length-2;j>=0;j--){
            if(nums[j+1]>rmax){
                rmax=nums[j+1];
                rightMax[j]=rmax;
            }else{
                rightMax[j]=rmax;
            }
        }

        int removeCount=0;
        for(int i=0;i<nums.length;i++){
            if (nums[i]<leftMax[i]&&nums[i]<rightMax[i]){
                removeCount+=1;
            }
        }
        //若最大值存在多个，移除重复的最大值
        int max = Arrays.stream(nums).max().getAsInt();
        int countMax=0;
        long count = Arrays.stream(nums).filter(t -> t == max).count();
        removeCount+=(int)count-1;
        return removeCount;
    }

    public static void main(String[] args) {

        int[] nums={9,8,1,7,6,5,4,3,2,1};
        P1671Try p1671Try=new P1671Try();
        int i = p1671Try.minimumMountainRemovals(nums);
        System.out.println(i);
    }
}
