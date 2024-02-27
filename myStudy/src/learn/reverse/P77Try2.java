package learn.reverse;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class P77Try2 {

    List<List<Integer>> res=new LinkedList<>();

    public void fun(List<Integer> term,int index,int n,int k){
        if(term.size()==k){
            res.add(term.stream().collect(Collectors.toList()));
        }
        else{
            for(int i=index+1;i<=n;i++){
                term.add(i);
                fun(term,i,n,k);
                term.remove(term.size()-1);
            }
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> term=new LinkedList<>();
        fun(term,0,n,k);
        return res;
    }

    public static void main(String[] args) {
        P77Try2 p77Try2=new P77Try2();
        int n=4;int k=2;
        List<List<Integer>> combine = p77Try2.combine(n, k);
        combine.stream().forEach(t->{
            t.stream().forEach(t2->{
                System.out.print(String.format("%d ",t2));
            });
            System.out.println();
        });
    }
}
