package learn.binary_search;

import java.util.Arrays;
import java.util.stream.IntStream;

public class P4Try {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        IntStream stream1 = Arrays.stream(nums1);
        IntStream stream2 = Arrays.stream(nums2);
        IntStream concat = IntStream.concat(stream1, stream2);
        int[] ints = concat.toArray();
        Arrays.sort(ints);
        if(ints.length%2==1){
            return (double)ints[ints.length/2];
        }else{
            int mid=ints.length/2-1;
            return (double)(ints[mid]+ints[mid+1])/2;
        }

    }

    public static void main(String[] args) {
        P4Try p4Try=new P4Try();
        int[]nums1=new int[] {1,2};
        int[] nums2=new int[]{3,4};
        double res = p4Try.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
