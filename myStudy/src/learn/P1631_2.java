package learn;

import java.util.Arrays;
import java.util.Stack;

public class P1631_2 {
//    Integer[][] heights= new Integer[][]{{1,2,2},{3,8,2},{5,3,5}};
    int[][] heights;
    class Index{
        int r;
        int c;

        Index(int r,int c){
            this.r=r;
            this.c=c;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }
    }
    Integer rowNum;
    Integer columnNum;
    Integer[][] isReached;
    Stack<Index> stack;

    //dfs

    public int minimumEffortPath(int[][] heights) {
        this.heights=heights;
        rowNum=this.heights.length;
        columnNum=this.heights[0].length;
        int result=0;
        int left=0;
        int right=5;
        for(;left<right;){
            int mid=(left+right)/2;
            boolean res = check(mid);
            if(res){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    public boolean check(int result){
        stack=new Stack<Index>();
        stack.push(new Index(0,0));
        isReached=new Integer[rowNum][columnNum];
        for(Integer[] row:isReached){
            Arrays.fill(row,0);
        }
        isReached[0][0]=1;
        while(!stack.isEmpty()){
            Index termIndex = stack.pop();
            tryReach(termIndex,-1,0,result);
            tryReach(termIndex,1,0,result);
            tryReach(termIndex,0,1,result);
            tryReach(termIndex,0,-1,result);
        }
        if(isReached[rowNum-1][columnNum-1]==1){
//                System.out.println("result:" + result);
            return true;
        }
        return false;
    }

    public Integer getValue(Index index,int[][] heights){
        return heights[index.getR()][index.getC()];
    }

    public void tryReach(Index termIndex,int moveRow,int moveColumn,int result){
        //判断当前坐标上下左右的坐标是否到达过
        //如果未到达则判断路径大小和result，如果小于result则可达，将新坐标加入stack，并修改isReached
        Index left=new Index(termIndex.getR()+moveRow,termIndex.getC()+moveColumn);
        if(left.getR()>=0&&left.getR()<rowNum&&left.getC()>=0&&left.getC()<columnNum){
            if(isReached[left.getR()][left.getC()]==0){
                if(Math.abs(getValue(termIndex,heights)-getValue(left,heights))<=result){
                    isReached[left.getR()][left.getC()]=1;
                    stack.add(left);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] heights= new int[][]{{1,2,2},{3,8,2},{5,3,5}};
        P1631_2 obj = new P1631_2();
        System.out.println(obj.minimumEffortPath(heights));
    }
}
