package learn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class P57Try {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals.length==0){
            intervals=new int[1][2];
            intervals[0]=newInterval;
            return intervals;
        }


        List<int[]> list= Arrays.asList(intervals).stream().collect(Collectors.toList());
        if(newInterval[1]<=intervals[0][0]){
            list.add(0,newInterval);
        }
        if(newInterval[0]>intervals[intervals.length-1][1]){
            list.add(newInterval);
        }
        List<Integer> remove=new LinkedList<>();
        //用于判断新区间是否在遍历中加入过旧区间序列
        Boolean isAdd=false;
        for(int i=0;i<list.size();i++){
            if(list.get(i)[1]<newInterval[0]){
                continue;
            }
            if(list.get(i)[0]>=newInterval[0]&&list.get(i)[1]<=newInterval[1]){
//                remove.add(i);
                list.get(i)[0]=newInterval[0];
                list.get(i)[1]=newInterval[1];
                isAdd=true;
                continue;

            }
            if(list.get(i)[0]>newInterval[1]){
                continue;
            }
            else if(list.get(i)[0]<=newInterval[0]&&list.get(i)[1]>=newInterval[0]&&list.get(i)[1]<=newInterval[1]){
                list.get(i)[1]=newInterval[1];
                isAdd=true;
            }
            else if(list.get(i)[0]>=newInterval[0]&&list.get(i)[0]<=newInterval[1]&&list.get(i)[1]>=newInterval[1]){
                list.get(i)[0]=newInterval[0];
                isAdd=true;
            }
        }
//        remove.stream().forEach(t->{
//            list.remove((int)t);
//        });
//        remove.clear();
        //若新区间没有加入过旧区间，则找到新区间应加入的位置
        if(isAdd==false){
            int i=0;
            while(i<intervals.length-1){
                if(intervals[i][1]<newInterval[0]&&intervals[i+1][0]>newInterval[0]){
                    list.add(i+1,newInterval);
                }
                i++;
            }
        }
        //统计区间序列中应被移除的区间下标，同时对区间进行融合
        for(int i=0;i<list.size();i++){
            if(i+1<list.size()){
                if(list.get(i)[1]>=list.get(i+1)[0]){
                    list.get(i+1)[0]=list.get(i)[0];
                    remove.add(i);
                }
            }
        }
        //使用remove对list按下标进行删除时，需先倒叙排列下标，先删除后方下标以避免影响前置下标
        Collections.sort(remove,(t1,t2)->{
            if(t1>t2){
                return -1;
            }else{
                return 1;
            }
        });
        if(!remove.isEmpty()){
            remove.stream().forEach(t->list.remove((int)t));
        }

        int[][] ints = list.stream().toArray(int[][]::new);
        return ints;
    }

    public static void main(String[] args) {
        P57Try p57Try=new P57Try();
//        int[][] in={{1,3},{6,9}};
//        int[][] in={{1,2},{3,5},{6,7},{8,10},{12,16}};
//        int[] nin={4,8};
        int[][] in={{3,5},{12,15}};
        int[] nin={6,6};
        int[][] insert = p57Try.insert(in, nin);
        Arrays.stream(insert).forEach(ints -> {
            System.out.println(ints[0]+" "+ints[1]);
        });
    }
}
