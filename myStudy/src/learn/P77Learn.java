package learn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P77Learn {

    List<List<Integer>> res=new LinkedList<>();
    public void fun(Deque<Integer> term,List<Integer> list,int index,int k){
        if(term.size()==k){
            res.add(term.stream().collect(Collectors.toList()));
//            term.removeLast();
        }
        else{
            for(int i=index;i<list.size();i++){
                term.addLast(list.get(i));
                fun(term,list,i+1,k);
                term.removeLast();
            }
        }
    }
    public List<List<Integer>> combine(int n, int k){
        List<Integer> datas = IntStream.range(1, n + 1).boxed().collect(Collectors.toList());
        Deque<Integer> term=new LinkedList<>();
//        term.addLast(datas.get(0));
        fun(term,datas,0,k);
        return res;
    }

    public static void main(String[] args) {
        P77Learn p77Learn=new P77Learn();
        int n=4;
        int k=2;
        p77Learn.combine(n,k);
        p77Learn.res.stream().forEach(t->{
            t.stream().forEach(t2->{
                System.out.print(t2+" ");
            });
            System.out.println();
        });
    }
}
