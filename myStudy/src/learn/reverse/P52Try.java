package learn.reverse;

import java.util.*;

//N皇后问题
public class P52Try {

    int[][] record;
    int n;
    int res=0;

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
    }

    public List<Index> effectIndex(Index index){
        List<Index> res=new LinkedList<>();
        for(int c=0;c<n;c++){
            int l1=index.l-(index.getC()-c);
            int l2=index.l+(index.getC()-c);
            int l3=index.l;
            if(l3==l1){
                for(int j=0;j<n;j++){
                    res.add(new Index(j,c));
                }

            }else{
                if(l1>=0&&l1<n){
                    res.add(new Index(l1,c));
                }
                if(l2>=0&&l2<n){
                    res.add(new Index(l2,c));
                }
                res.add(new Index(l3,c));
            }
        }
        return res;
    }
    public Map<Index,Integer> lock(List<Index> list){
        Map<Index,Integer> map=new HashMap<>();
        list.stream().forEach(t->{
            map.put(t,record[t.getL()][t.getC()]);
            record[t.getL()][t.getC()]=1;
        });
        return map;
    }
    public void unlock(List<Index> list,Map<Index,Integer> map){
        list.stream().forEach(t->{
            record[t.getL()][t.getC()]=map.get(t);
        });
    }

    public void fun(int c,List<Integer> term){
        if(c==n){
            res+=1;
        }else{
            for(int l=0;l<n;l++){
                Index index = new Index(l, c);
                if(record[l][c]==1){
                    continue;
                }else{
                    List<Index> indexs = effectIndex(index);
                    Map<Index, Integer> lockMap = lock(indexs);
                    term.add(l);
                    fun(c+1,term);
                    term.remove(term.size()-1);
                    //回退棋盘状态
                    unlock(indexs,lockMap);
                    indexs=null;
                }
            }
        }
    }

    public int totalNQueens(int n) {
        this.n = n;
        this.record=new int[n][n];
        List<Integer> term=new LinkedList<>();
        fun(0,term);
        return res;
    }

    public static void main(String[] args) {
        P52Try p52Try=new P52Try();
        int res = p52Try.totalNQueens(4);
        System.out.println(res);
    }
}
