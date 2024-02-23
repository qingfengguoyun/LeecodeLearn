import java.util.Arrays;
import java.util.Stack;

public class P1631 {


//    [[1,2,2],[3,8,2],[5,3,5]]

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
    Integer[][] heights= new Integer[][]{{1,2,2},{3,8,2},{5,3,5}};
    Integer rowNum=heights.length;
    Integer columnNum=heights[0].length;
    Integer[][] record;
    Integer[][] isDecided;
    Stack<Index> stack;
    public void solution(Integer[][] heights){

        rowNum=heights.length;
        columnNum=heights[0].length;
        record=new Integer[rowNum][columnNum];
        for(Integer[] row:record){
            Arrays.fill(row,0);
        }
        isDecided=new Integer[rowNum][columnNum];
        for(Integer[] row:isDecided){
            Arrays.fill(row,0);
        }
        isDecided[0][0]=1;
        stack=new Stack<Index>();

//        stack.push()
    }


    public void check(Index tar,Index from){

        int r=tar.getR();
        int c=tar.getC();
        int fr=from.getR();
        int fc=from.getC();
        if(isDecided[r][c]==1){
            return;
        }
        //目标左侧存在
        if((c-1)>=0){
            Index left = new Index(r - 1, c);
        }
        //目标右侧存在
        if((c+1)<columnNum){
            Index right = new Index(r , c+1);
        }
        //目标上侧存在
        if((r-1)>=0){
            Index up = new Index(r-1 , c);
        }
        //目标下侧存在
        if((r+1)<rowNum){
            Index down = new Index(r+1 , c);
        }

    }


}
