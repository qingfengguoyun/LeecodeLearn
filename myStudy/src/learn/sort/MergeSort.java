package learn.sort;

import java.util.Arrays;

public class MergeSort {
    public void mergeSort(int left,int right,int mid,Integer[]array,Integer[] term){
        if(left<right){
            mergeSort(left,mid,(left+mid)/2,array,term);
            mergeSort(mid+1,right,(right+mid)/2,array,term);
            sort(left,right,mid,array,term);
        }
    }

    public void sort(int left,int right,int mid,Integer[] array,Integer[] term){
        if(left<right){
            int l=left;
            int m=mid+1;
            int i=left;
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
            for(i=left;i<=right;i++){
                array[i]=term[i];
            }
        }

    }

    public static void main(String[] args) {
        MergeSort mergeSort=new MergeSort();
        Integer[] array={1,4,5,2,3,3,7,8,0,2,5};
        Integer[] term=new Integer[array.length];
        mergeSort.mergeSort(0,array.length-1,(array.length-1)/2,array,term);
        Arrays.asList(array).stream().forEach(t-> System.out.println(t));
    }
}
