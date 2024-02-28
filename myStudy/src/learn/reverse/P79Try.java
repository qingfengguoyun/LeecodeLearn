package learn.reverse;

public class P79Try {
    boolean[][][] record;

    public boolean res=false;

    public boolean validate(int l,int c,boolean[][] record){
        int lines=record.length;
        int colnums=record[0].length;
        if(l>=0&&l<lines&&c>=0&&c<colnums){
            if(record[l][c]==false){
                return true;
            }
        }
        return false;
    }

    public void fun(int term ,char[] words,char[][] board,int l,int c,int length){
        if(term==length){
            res=true;
        }else{
            if(board[l][c]==words[term]){
                record[term][l][c]=true;
                if(term+1==length){
                    res=true;
                    return;
                }
                for(int l2:new int[]{l-1,l+1}){
                    if(validate(l2,c,record[term+1])){
                        fun(term+1,words,board,l2,c,length);
                    }
                }
                for(int c2:new int[]{c-1,c+1}){
                    if(validate(l,c2,record[term+1])){
                        fun(term+1,words,board,l,c2,length);
                    }
                }
                record[term][l][c]=false;
            }
            else{
                record[term][l][c]=true;
                for(int l2:new int[]{l-1,l+1}){
                    if(validate(l2,c,record[term])){
                        fun(term,words,board,l2,c,length);
                    }
                }
                for(int c2:new int[]{c-1,c+1}){
                    if(validate(l,c2,record[term])){
                        fun(term,words,board,l,c2,length);
                    }
                }
                record[term][l][c]=false;
            }
        }
    }

    public boolean exist(char[][] board, String word) {
        int term=0;
        int length=word.length();
        record=new boolean[word.length()][board.length][board[0].length];
//        for(boolean[] list:record){
//            for (boolean b:list){
//                System.out.print(b+" ");
//            }
//            System.out.println();
//        }
        fun(term,word.toCharArray(),board,0,0,length);
        return res;
    }

    public static void main(String[] args) {
        P79Try p79Try=new P79Try();
        char[][] board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="ABCB";
//        char[][] board=new char[][]{{'A','B'},{'C','D'}};
//        String word="DBAC";
//        char[][] board=new char[][]{{'A'}};
//        String word="A";
        boolean exist = p79Try.exist(board, word);
        System.out.println(exist);
    }
}
