package practice.sort_2024_2_19;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public void swap(int left,int right,int[] array){
        int val=array[left];
        array[left]=array[right];
        array[right]=val;
    }

    public void quickSort(int left,int right,int[] array){
        if(left<right){
            int mid = fun(left,right ,array);
            quickSort(left,mid-1,array);
            quickSort(mid+1,right,array);
        }
    }

    public Integer fun(int left,int right,int[] array){
        int tar= (new Random().nextInt(right-left))%(right-left)+left;
        int val=array[tar];
        //随机选择值后需与最右（最左）侧值进行交换
        swap(tar,right,array);
//        tar=right;
        while(left<right){
            while(array[left]<=val&&left<right){
                left++;
            }
            swap(left,right,array);
//            tar=left;
            while(array[right]>=val&&left<right){
                right--;
            }
            swap(right,left,array);
//            tar=right;
        }
//        array[left]=val;
        return left;
    }

    public static void main(String[] args) {
        int[] array=new int[]{3,7,4,9,6,1,2,4};
        QuickSort quickSort=new QuickSort();
        quickSort.quickSort(0,array.length-1,array);
        Arrays.stream(array).forEach(t->{
            System.out.println(t);
        });
    }
}
