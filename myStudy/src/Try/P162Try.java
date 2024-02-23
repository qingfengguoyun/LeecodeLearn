package Try;

public class P162Try {
    public int findPeakElement(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        if(nums.length==2){
            return nums[0]>nums[1]?0:1;
        }
        int mid=1;
        for( mid=1;mid<nums.length-1;mid++){
            if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]){
                return mid;
            }
        }
        if(nums[mid]>nums[mid-1]){
            return mid;
        }
        return 0;
    }

    public static void main(String[] args) {
        P162Try p162Try =new P162Try();
        int[] nums={1,2,1,3,5,6,4};
        int peakElement = p162Try.findPeakElement(nums);
        System.out.println(peakElement);
    }
}
