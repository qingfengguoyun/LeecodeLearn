package learn.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public void swap(int left,int right,Integer[] array){
        Integer term=array[right];
        array[right]=array[left];
        array[left]=term;
    }

    public void quickSort(int left,int right,Integer[] array){
        if(left<right){
            Integer sort = sort(left, right, array);
            quickSort(left,sort-1,array);
            quickSort(sort+1,right,array);
        }
    }

    public Integer sort(int left,int right,Integer[] array){

        Integer mid=right;
        Integer value=array[right];
        while(left<right){
            while(array[left]<=value&&left<right){
                left++;
            }
            swap(left,mid,array);
            mid=left;
            while(array[right]>=value&&left<right){
                right--;
            }
            swap(right,mid,array);
            mid=right;
        }
        return left;
    }

    public static void main(String[] args) {
        QuickSort quickSort=new QuickSort();
        Integer[] array={1,4,5,2,3,3};
        quickSort.quickSort(0,5,array);
        Arrays.asList(array).stream().forEach(t-> System.out.println(t));
    }
}
