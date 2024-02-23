package learn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P54Try {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowNext=0;
        int colNext=1;
        boolean check[][]=new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<check.length;i++){
            Arrays.fill(check[i],false);
        }
        int row=0;
        int column=0;
        int totalCount=(matrix.length)*(matrix[0].length);
        int count=0;
        List<Integer> resList=new LinkedList<>();
        while(count<totalCount){
            resList.add(matrix[row][column]);
            check[row][column]=true;
            //右行状态，碰右壁向下
            if(colNext==1&&rowNext==0){
                if(column+1>=matrix[0].length||check[row][column+1]){
                    rowNext=1;
                    colNext=0;
                }
            }
            //左行状态，碰左壁向上
            if(colNext==-1&&rowNext==0){
                if(column-1<0||check[row][column-1]){
                    rowNext=-1;
                    colNext=0;
                }
            }
            //下行状态，碰下壁向左
            if(colNext==0&&rowNext==1){
                if(row+1>=matrix.length||check[row+1][column]){
                    rowNext=0;
                    colNext=-1;
                }
            }
            //上行状态，碰上壁向右
            if(colNext==0&&rowNext==-1){
                if(row-1<=0||check[row-1][column]){
                    rowNext=0;
                    colNext=1;
                }
            }
            row+=rowNext;
            column+=colNext;
            count++;
        }
        return resList;
    }

    public static void main(String[] args) {
        P54Try p54Try=new P54Try();
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = p54Try.spiralOrder(matrix);
        System.out.println(list);
    }
}
