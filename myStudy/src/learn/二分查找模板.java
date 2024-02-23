package learn;

public class 二分查找模板 {

    public boolean check(){
        //目标条件
        return true;
    }

    public int binarySerach1(int[] nums){

        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=(left+right)/2+1;
            if(check()){
                //目标条件满足时向右搜索
                left=mid;
            }else {
                right=mid-1;
            }
        }
        return left;
    }

    public int binarySerach2(int[] nums){

        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(check()){
                //目标条件满足时向左搜索
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return left;
    }
}
