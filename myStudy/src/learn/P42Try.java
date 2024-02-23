package learn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P42Try {
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int max=0,maxIndex=0;
        for(int i=0;i<height.length;i++){
            if(height[i]>=max){
                max=height[i];
                maxIndex=i;
            }
        }
        int sum=max;
        int hleft=height[0],ileft=0;
        int hright=height[right],iright=height.length-1;
        while(left<maxIndex){
            while(height[left]<=hleft&&left<maxIndex){
                left++;
            }
            sum+=(left-ileft)*hleft;
            hleft=height[left];
            ileft=left;
        }
        while(right>maxIndex){
            while(height[right]<=hright&&right>maxIndex){
                right--;
            }
            sum+=(iright-right)*hright;
            hright=height[right];
            iright=right;
        }
        int sum1 = Arrays.stream(height).sum();
        return sum-sum1;
    }

    public static void main(String[] args) {
        P42Try p42Try=new P42Try();
//        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] height={4,2,0,3,2,5};
        int[] height={2,0,2};
        int trap = p42Try.trap(height);
        System.out.println(trap);
    }
}
