package learn.reverse;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P77Try {

    List<List<Integer>> res=new LinkedList<>();
    public void fun(List<Integer> intList,List<Integer> term,int k,Integer addt){
        if(term.size()==k){
            res.add(term.stream().collect(Collectors.toList()));
//            term.remove(addt);
        }else{
            intList.stream().forEach(t->{
                if(!term.contains(t)&&addt<t){
                    List<Integer> list = term.stream().collect(Collectors.toList());
                    list.add(t);
                    fun(intList,list,k,t);
                }
            });
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> intList = IntStream.range(1, n + 1).boxed().collect(Collectors.toList());
        List<Integer> term=new LinkedList<>();
        fun(intList,term,k,0);
        return res;
    }

    public static void main(String[] args) {
        P77Try p77Try=new P77Try();
        int n=4;
        int k=2;
        p77Try.combine(n,k);
        p77Try.res.stream().forEach(t->{
            t.stream().forEach(t2->{
                System.out.print(t2+" ");
            });
            System.out.println();
        });
    }
}
