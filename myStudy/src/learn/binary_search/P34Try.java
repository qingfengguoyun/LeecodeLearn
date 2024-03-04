package learn.binary_search;

public class P34Try {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int left=0,right=nums.length-1;
        int mid=0;
        //第一次二分查找，找是否存在目标值
        while(left<right){
            mid=(left+right)/2;
            if(nums[mid]<target){
                left=mid+1;
            }
            if(nums[mid]>target){
                right=mid;
            }
            if(nums[mid]==target){
                break;
            }
        }
        //如果没找到则返回-1，-1
        if(left==right&&nums[left]!=target){
            return new int[]{-1,-1};
        }
        //有且仅有一个，返回对应值
        if(left==right&&nums[left]==target){
            return new int[]{left,left};
        }
        //分别找左右边界
        int r1=mid;
        int l1=mid;
        //分别使用二分查找的两个模板
        while(left<r1){
            int midl=(left+r1)/2;
            if(nums[midl]==target){
                r1=midl;
            }else{
                left+=1;
            }
        }
        while(l1<right){
            int midr=(l1+right)/2+1;
            if(nums[midr]==target){
                l1=midr;
            }else{
                right=midr-1;
            }
        }
        return new int[]{left,l1};
    }

    public static void main(String[] args) {
        P34Try p34Try=new P34Try();
        int[] nums=new int[]{5,7,7,8,8,10};
        int target=10;
        int[] ints = p34Try.searchRange(nums, target);
        System.out.println(String.format("%d %d",ints[0],ints[1]));
    }
}
