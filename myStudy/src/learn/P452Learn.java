package learn;

import java.util.Arrays;

public class P452Learn {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->{
            if(a[0]>b[0]){
                return 1;
            }else if(a[0]==b[0]){
                return 0;
            }else return -1;
        });
        int left=points[0][0];
        int  right=points[0][1];
        int count=1;
        for(int i=1;i<points.length;i++){
            int tl=points[i][0];
            int tr=points[i][1];
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
        P452Learn p452Learn=new P452Learn();
        int[][] intervals={{10,16},{2,8},{1,6},{7,12}};
        int minArrowShots = p452Learn.findMinArrowShots(intervals);
        System.out.println(minArrowShots);
    }
}
