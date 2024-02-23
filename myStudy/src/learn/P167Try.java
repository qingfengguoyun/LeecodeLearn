package learn;

public class P167Try {
    public int[] twoSum(int[] numbers, int target) {
        int l=0,r=numbers.length-1;
        while(l<r){
            if(numbers[l]==target-numbers[r]){
                break;
            }
            else if(numbers[l]<target-numbers[r]){
                l++;
            }
            else {
                r--;
            }
        }
        int[] res=new int[2];
        res[0]=l+1;
        res[1]=r+1;
        return res;
    }

    public static void main(String[] args) {
        P167Try p167Try=new P167Try();
        int[] numbers={2,7,11,15};
        int target=9;
        int[] res = p167Try.twoSum(numbers, target);
        System.out.println(" "+res[0]+res[1]);
    }
}
