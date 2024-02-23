package learn;

public class P189L {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        int[] nums2=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            nums2[i]=nums[(i-k+nums.length)%nums.length];
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=nums2[i];
        }
    }

    public static void main(String[] args) {
        P189L p189L=new P189L();
        int[] nums={1,2,3,4,5,6,7};
        p189L.rotate(nums,3);
        for(int i:nums){
            System.out.println(i);
        }
    }
}
