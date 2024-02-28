package learn.reverse;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class P79Learn {

    class Index{
        int l;
        int c;

        public Index(int l, int c) {
            this.l = l;
            this.c = c;
        }

        public int getL() {
            return l;
        }

        public void setL(int l) {
            this.l = l;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Index)) return false;
            Index index = (Index) o;
            return l == index.l &&
                    c == index.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(l, c);
        }

        public Index nextIndex(String option){
            switch (option){
                case "up":
                    return new Index(this.l-1,this.c);
                case "down":
                    return new Index(this.l+1,this.c);
                case "left":
                    return new Index(this.l,this.c-1);
                case "right":
                    return new Index(this.l,this.c+1);
            }
            return this;
        }
    }

    boolean res=false;

    String[] options=new String[]{"up","down","left","right"};

    public boolean validate(List<Index> list,char[][] board,Index index){
        if(index.l>=0&&index.l<board.length&&index.c>=0&&index.c<board[0].length){
            if(!list.contains(index)){
               return true;
            }
        }
        return false;
    }

    public void fun (List<Index> list, char[][] board, Index index, int count, char[] words){
        if(res==true){
            return;
        }else{
            if(board[index.l][index.c]==words[count]){
                list.add(index);
                if(list.size()==words.length){
                    res=true;
                    return;
                }
                for(String op:options){
                    Index next=index.nextIndex(op);
                    if(validate(list,board,next)){
                        fun(list,board,next,count+1,words);
                    };
                }
                list.remove(list.size()-1);
            }
        }
    }

    public boolean exist(char[][] board, String word) {
        //遍历所有位置，对所有位置执行深度优先搜索
        for(int l=0;l<board.length;l++){
            for(int c=0;c<board[0].length;c++){
                List<Index> term=new LinkedList<>();
                fun(term,board,new Index(l,c),0,word.toCharArray());
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        char[][] board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word="SEE";
        char[][] board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="ABCB";
        P79Learn p79Learn=new P79Learn();
        boolean exist = p79Learn.exist(board, word);
        System.out.println(exist);
    }

}
