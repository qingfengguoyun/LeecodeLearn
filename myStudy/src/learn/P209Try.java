package learn;

public class P209Try {
    public Boolean check(int tar,int[] nums,int size){
        if(size>nums.length){
            return false;
        }
        int sum=0;
        int i=0;
        for(i=0;i<size;i++){
            sum+=nums[i];
        }
        for(i=0;i<nums.length-size;i++){
            if(sum>=tar){
                return true;
            }else{
                sum-=nums[i];
                sum+=nums[i+size];
            }
        }
        if(sum>=tar){
            return true;
        }
        return false;
    }
    public int minSubArrayLen(int target, int[] nums) {
        int left=1;
        int right=nums.length;
        while(left<right){
            int mid=(left+right)/2;
            if(check(target,nums,mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return check(target,nums,left)?left:0;

    }

    public static void main(String[] args) {
        P209Try p209Try=new P209Try();
        int[] nums={1,2,3,4,5};
        int target=11;
        int i = p209Try.minSubArrayLen(target, nums);
        System.out.println(i);
    }
}
