package learn;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.LinkedList;
import java.util.List;

public class P228Try {
    public List<String> summaryRanges(int[] nums) {
        List<String> res=new LinkedList<>();
        if(nums.length==0){
            return res;
        }
        int left=0,right=0;
        StringBuilder builder=new StringBuilder();
        while(right<nums.length){
            if(left==right){
                builder.append(""+nums[left]);
                right++;
            }
            else{
                if(nums[right]-nums[right-1]==1){
                    right++;
                }else{
                    if(nums[left]!=nums[right-1]){
                        builder.append("->"+nums[right-1]);
                    }
                    res.add(builder.toString());
                    builder=new StringBuilder();
                    left=right;
                }
            }
        }
//        builder.append(nums[right-1]);
        if(nums[left]!=nums[right-1]){
            builder.append("->"+nums[right-1]);
        }
        res.add(builder.toString());
        return res;
    }

    public static void main(String[] args) {
        P228Try p228Try=new P228Try();
        int[] nums={0,2,3,4,6,8,9};
        List<String> strings = p228Try.summaryRanges(nums);
        strings.stream().forEach(t-> System.out.println(t));
    }
}
