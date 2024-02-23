package learn;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P15Try {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer,Integer> recordMap=new HashMap<>();
        Map<Integer, Integer> indexMap = IntStream.range(0, nums.length).boxed().collect(Collectors.toMap(i -> i, i -> nums[i]));
        LinkedHashMap<Integer, Integer> sortedMap = indexMap.entrySet().stream().sorted(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getKey() > o2.getKey()) {
                    return -1;
                } else {
                    return 1;
                }
//                return o1.getValue()>o2.getValue();
            }
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(sortedMap);
        return null;
    }

    public static void main(String[] args) {
        P15Try p15Try=new P15Try();
        int[] nums={2,5,1,4,8,6,2};
        p15Try.threeSum(nums);
    }
}
