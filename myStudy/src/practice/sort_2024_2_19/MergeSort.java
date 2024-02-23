package practice.sort_2024_2_19;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int left,int right,int[] array){
        if(left<right){
            int mid=(right+left)/2;
            mergeSort(left,mid,array);
            mergeSort(mid+1,right,array);
            merge(left,mid,right,array );
        }
    }

    public void merge(int left,int mid,int right,int[] array){
        int[] term=new int[array.length];
        int i=left;
        int l=left;
        int m=mid+1;
        int start=left;
        while(l<=mid&&m<=right){
            if(array[l]<array[m]){
                term[i]=array[l];
                l++;i++;
            }else{
                term[i]=array[m];
                m++;i++;
            }
        }
        while(l<=mid){
            term[i]=array[l];
            l++;i++;
        }
        while(m<=right){
            term[i]=array[m];
            m++;i++;
        }
        for(int j=start;j<i;j++){
            array[j]=term[j];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort=new MergeSort();
        int[] array=new int[]{3,7,4,9,6,1,2,4};
        mergeSort.mergeSort(0,array.length-1,array);
        Arrays.stream(array).forEach(t->{
            System.out.println(t);
        });
    }
}
