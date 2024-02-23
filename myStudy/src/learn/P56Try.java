package learn;

import java.util.*;
import java.util.stream.Collectors;



public class P56Try {

    class MyCompare  implements Comparator<List<Integer>> {

        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            if(o1.get(0)<o2.get(0)){
                return -1;
            }else if(o1.get(0)==o2.get(0)){
                return 0;
            }else{
                return 1;
            }
//
        }
    }

    public int[][] merge(int[][] intervals) {
        List<List<Integer>> list=new LinkedList<>();
        for(int[] array:intervals){
            List<Integer> collect = Arrays.stream(array).boxed().collect(Collectors.toList());
            list.add(collect);
        }
        Collections.sort(list,new MyCompare());
//        list.stream().forEach(t->{
//            t.stream().forEach(o->{
//                System.out.print(o+" ");
//            });
//            System.out.println();
//        });
        int left=list.get(0).get(0);
        int right=list.get(0).get(1);
        List<List<Integer>> res=new LinkedList<>();
        for(List<Integer> tList:list){
            if(tList.get(0)>right){
                List<Integer> term=new LinkedList<>();
                term.add(left);
                term.add(right);
                res.add(term);
                left=tList.get(0);
                right=tList.get(1);
            }else{
                right=right>tList.get(1)?right:tList.get(1);
            }
        }
        List<Integer> term=new LinkedList<>();
        term.add(left);
        term.add(right);
        res.add(term);
//        res.stream().forEach(t->{
//            t.stream().forEach(o->{
//                System.out.print(o+" ");
//            });
//            System.out.println();
//        });
        int[][] resArray=new int[res.size()][2];
        for(int i=0;i<resArray.length;i++){
            resArray[i][0]=res.get(i).get(0);
            resArray[i][1]=res.get(i).get(1);
        }
        return resArray;
    }

    public static void main(String[] args) {
        P56Try p56Try=new P56Try();
        int[][] intervals={{3,7},{2,5},{4,8}};
        p56Try.merge(intervals);

    }
}
