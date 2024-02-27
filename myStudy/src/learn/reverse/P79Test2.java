package learn.reverse;

import java.util.Arrays;
import java.util.List;

public class P79Test2 {

    boolean res;
//    boolean[][] record;

    public boolean validate(int l,int c,boolean[][] record,char[][] board, char w){
        if(l>=0&&l<record.length&&c>=0&&c<record[0].length){
            if(record[l][c]==false){
                if(board[l][c]==w){
                    return true;
                }
            }
        }
        return false;
    }
    public void fun(int term,char[][] board,boolean[][] record,char[] words,int l,int c,int length){
        if(res==true){

        }else{
            record[l][c]=true;
            if(term+1==length){
                res=true;
                return;
            }else{
                int[] array=new int[]{-1,1};
                for(int i:array){
                    if(validate(l+i,c,record,board,words[term+1])){
                        fun(term+1,board,record,words,l+i,c,length);
                    }
                }
                for(int i:array){
                    if(validate(l,c+i,record,board,words[term+1])){
                        fun(term+1,board,record,words,l,c+i,length);
                    }
                }
            }
        }
    }

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int l=0;l<board.length;l++){
            for(int c=0;c<board[0].length;c++){
                if(board[l][c]==words[0]){
                    boolean[][] record=new boolean[board.length][board[0].length];
                    fun(0,board,record,words,l,c,words.length);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="SEE";
        P79Test2 p79Test2=new P79Test2();
        boolean exist = p79Test2.exist(board, word);
        System.out.println(exist);
    }
}
