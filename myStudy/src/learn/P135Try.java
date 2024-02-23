package learn;

import java.util.Arrays;

public class P135Try {
    public int candy(int[] ratings) {
        int[] count=new int[ratings.length];
        Arrays.fill(count,1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                count[i]=count[i-1]+1;
            }
            else{
//                count[i]=count[i-1];
            }
        }
        int[] countRight=new int[ratings.length];
        Arrays.fill(countRight,1);
        for(int i=ratings.length-1;i>0;i--){
            if(ratings[i-1]>ratings[i]){
                countRight[i-1]=countRight[i]+1;
            }
            else{
//                count[i]=count[i-1];
            }
        }
//        int min = Arrays.stream(count).min().getAsInt();
        int sum=0;
        for(int i=0;i<count.length;i++){
            sum+=count[i]>countRight[i]?count[i]:countRight[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        P135Try p135Try=new P135Try();
        int[] ratings={1,0,2};
        int sum = p135Try.candy(ratings);
        System.out.println(sum);
    }
}
