package learn;

public class P11Learn {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int max=(right-left)*(height[left]<height[right]?height[left]:height[right]);
        while(left<right){
            if(height[left]>height[right]){
                right--;
            }else{
                left++;
            }
            int count=(right-left)*(height[left]<height[right]?height[left]:height[right]);
            max=max>count?max:count;
        }
        return max;
    }

    public static void main(String[] args) {
        P11Learn p11Learn=new P11Learn();
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(p11Learn.maxArea(height));
    }
}
