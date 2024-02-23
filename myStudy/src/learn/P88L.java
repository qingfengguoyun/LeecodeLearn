package learn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P88L {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] res=new int[nums1.length];
        int i=0,j=0,k=0;
        while (i<m&&j<n){
            if(nums1[i]<=nums2[j]){
                res[k]=nums1[i];
                k++;i++;
            }
            else {
                res[k]=nums2[j];
                k++;j++;
            }

        }
        while(i<m){
            res[k]=nums1[i];
            k++;i++;
        }
        while(j<n){
            res[k]=nums2[j];
            k++;j++;
        }
        for(int q=0;q<nums1.length;q++){
            nums1[q]=res[q];
        }

    }

    public static void main(String[] args) {
        int[] num1={1,2,3,0,0,0};
        int[] nun2={2,5,6};
        P88L p88L=new P88L();
        p88L.merge(num1,3,nun2,3);
        for(int i=0;i<num1.length;i++){
            System.out.println(num1[i]);
        }


    }
}
