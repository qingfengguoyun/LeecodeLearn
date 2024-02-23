package learn;

public class P162L {
    public int findPeakElement(int[] nums){
        if(nums.length==1){
            return 0;
        }
        if(nums.length==2){
            return nums[0]>nums[1]?0:1;
        }
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]<nums[mid+1]){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return left;

    }

    public static void main(String[] args) {
        P162L p162L=new P162L();
        int[] nums={1,2,3,4,5,6};
        int peakElement = p162L.findPeakElement(nums);
        System.out.println(peakElement);
    }
}
