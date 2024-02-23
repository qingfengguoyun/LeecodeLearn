package learn;

import java.util.*;
import java.util.stream.Collectors;

public class P452Try {
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



    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points,(a,b)->{
            if(a[0]>b[0]){
                return 1;
            }else if (a[0]==b[0]){
                return 0;
            }else{
                return -1;
            }
        });
        for(int i=0;i<points.length;i++){
            System.out.print(points[i][0]+" "+points[i][1]);
            System.out.println();
        }

        if(points.length==0){
            return 0;
        }
        List<List<Integer>> list=new LinkedList<>();
        for(int i=0;i<points.length;i++){
            list.add(Arrays.stream(points[i]).boxed().collect(Collectors.toList()));
        }
//        Collections.sort(list,new MyCompare());
        int left=list.get(0).get(0);
        int right=list.get(0).get(1);
        int count=1;
        for (int i=1;i<list.size();i++){
            int tl=list.get(i).get(0);
            int tr=list.get(i).get(1);
            if(tl>right){
                count+=1;
                left=tl;
                right=tr;
            }
            else if (tl<=left&&tr>=right){

            }else if (tl<=left&&tr<right){
                right=tr;
            }else if (tl>left&&tr>=right){
                left=tl;
            }else if (tl>left&&tr<right){
                left=tl;
                right=tr;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        P452Try p452Try=new P452Try();
//        int[][] intervals={{10,16},{2,8},{1,6},{7,12}};
        int[][] intervals={{-2147483646,-2147483645},{2147483646,2147483647}};
        int minArrowShots = p452Try.findMinArrowShots(intervals);
        System.out.println(minArrowShots);
    }
}
