package learn;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P80L {

    public int removeDuplicates(int[] nums) {
        int i=0;
        int count=1;
        int value=nums[0];
        if(nums.length<=2){
            return nums.length;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int j=0;j<nums.length;j++){
            if(!map.keySet().contains(nums[j])){
                nums[i]=nums[j];
            }
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            if(map.getOrDefault(nums[j],0)<=2){
                nums[i]=nums[j];
                i++;
            }

        }
        return i;
    }

    public static void main(String[] args) {
//        int[] nums={1,1,1,2,2,3};
        int[] nums={0,0,1,1,1,1,2,3,3};
        P80L p80L=new P80L();
        int x = p80L.removeDuplicates(nums);
        System.out.println(x);
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for(int i=0;i<x;i++){
            System.out.println(nums[i]);
        }
    }
}
