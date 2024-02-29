package learn.linkList;

public class P35Try {


    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int res=-1;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                res=mid;return res;
            }
            else{
                if(nums[mid]>target){
                    right=mid;
                }
                if(nums[mid]<target){
                    left=mid+1;
                }
            }
        }
        if(nums[left]<target){
            res=left+1;
        }else{
            res=left;
        }
        return res;
    }

    public static void main(String[] args) {
        P35Try p35Try=new P35Try();
        int[] nums=new int[]{1,3,5,6};
        int target=5;
        int i = p35Try.searchInsert(nums, target);
        System.out.println(i);
    }
}
