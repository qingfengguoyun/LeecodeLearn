package learn;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 */
public class P11Try {
    public int maxArea(int[] height) {
        int max=0;
        int length=height.length;
        for(int left=0;left<height.length;left++){
            if((length-left)*height[left]<max){
                continue;
            }
            int termRight=height[length-1];
            for(int right=length-1;right>left;right--){
                if(height[right]<termRight){
                    continue;
                }else{
                    int count=(right-left)*(height[right]<height[left]?height[right]:height[left]);
                    max=count>max?count:max;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        P11Try p11Try=new P11Try();
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(p11Try.maxArea(height));
    }
}
