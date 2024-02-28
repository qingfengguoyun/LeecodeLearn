package learn.reverse;

import java.util.Arrays;

public class P79Learn2 {

    boolean res;
//    Arrays.asList(new int[]{-1,0})
    int[][] options=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public boolean validate(int l,int c,char[][] board){
        if(l>=0&&l<board.length&&c>=0&&c<board[0].length){
            return true;
        }
        return false;
    }

    public void fun(int index,char[][] board,char[] words,int l,int c){
        if(index==words.length){
            res=true;
            return;
        }else{
            if(board[l][c]==words[index]){
                index+=1;
                if(index==words.length){
                    res=true;
                    return;
                }
                board[l][c]='#';
                for(int[] op: options){
                    if(validate(l+op[0],c+op[1],board)){
                        fun(index,board,words,l+op[0],c+op[1]);
                    }
                }
                index-=1;
                board[l][c]=words[index];
            }
        }
    }


    public boolean exist(char[][] board, String word) {
        for(int l=0;l<board.length;l++){
            for(int c=0;c<board[0].length;c++){
                int index=0;
                fun(0,board,word.toCharArray(),l,c);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        P79Learn2 p79Learn2=new P79Learn2();
//        char[][] board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word="SEE";
//        char[][] board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word="ABCB";
        char[][] board=new char[][]{{'A'}};
        String word="A";
        boolean exist = p79Learn2.exist(board, word);
        System.out.println(exist);
    }
}
