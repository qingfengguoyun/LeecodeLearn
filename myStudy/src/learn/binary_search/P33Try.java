package learn.binary_search;

public class P33Try {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        //target小于最左，大于最右，说明必然不存在
        if(target>nums[nums.length-1]&&target<nums[0]){
            return -1;
        }
        while(left<right){
            int mid=(left+right)>>1;
            if(nums[mid]==target){
                return mid;
            }
            //处理target为最左，最右值的情况
            if(nums[left]==target){
                return left;
            }
            if(nums[right]==target){
                return right;
            }
            //判断target 和nums[left] nums[right]的关系
            if(target<nums[nums.length-1]){
                if(nums[mid]>nums[right]){
                    left=mid+1;
                }else{
                    if(nums[mid]>target){
                        right=mid;
                    }else{
                        left=mid+1;
                    }
                }
            }
            else{
                if(target>nums[0]){
                    if(nums[mid]<nums[left]){
                        right=mid;
                    }else{
                        if (nums[mid]>target){
                            right=mid;
                        }else{
                            left=mid+1;
                        }
                    }
                }
            }
        }
        if(nums[left]==target){
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        P33Try p33Try=new P33Try();
        int[] nums=new int[]{4,5,6,7,0,1,2};
        int target=0;
        int search = p33Try.search(nums, target);
        System.out.println(search);
    }
}
