package learn.reverse;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//N皇后
public class P51Try {

    List<List<Integer>> res=new LinkedList<>();

    public List<Integer> checkAvalibaleIndex(List<Integer> term,int c,int n){
        if(c==0){
            return IntStream.range(0,n).boxed().collect(Collectors.toList());
        }else{
            LinkedList<Integer> list = new LinkedList<>();
            int[] forbidIndex=new int[n];
            for(int i=0;i<term.size();i++){
                Integer l1=term.get(i)+(c-i);
                if(l1>=0&&l1<n){
                    forbidIndex[l1]=1;
                }
                Integer l2=term.get(i)-(c-i);
                if(l2>=0&&l2<n){
                    forbidIndex[l2]=1;
                }
                forbidIndex[term.get(i)]=1;
            }
            for(int i=0;i<forbidIndex.length;i++){
                if(forbidIndex[i]!=1){
                    list.add(i);
                }
            }
            return list;
        }
    }

    public void fun(List<Integer> term,int c,int n){
        if(c==n){
            res.add(term.stream().collect(Collectors.toList()));
        }else{
            List<Integer> list = checkAvalibaleIndex(term, c, n);
            if(list.isEmpty()){

            }else{
                list.stream().forEach(t->{
                    term.add(t);
                    fun(term,c+1,n);
                    term.remove(term.size()-1);
                });
            }
        }
    }

    public List<String> convert(List<Integer> list){
        LinkedList<String> strList = new LinkedList<>();
        list.stream().forEach(t->{
            StringBuilder builder=new StringBuilder();
            for(int i=0;i<list.size();i++){
                if(i!=t){
                    builder.append(".");
                }else{
                    builder.append("Q");
                }
            }
            strList.add(builder.toString());
        });
        return strList;
    }

    public List<List<String>> solveNQueens(int n) {
        List<Integer> term=new LinkedList<>();
        fun(term,0,n);
        List<List<String>> strRes=new LinkedList<>();
        res.stream().forEach(t->{
             strRes.add( convert(t));
        });
        return strRes;
    }

    public static void main(String[] args) {
        P51Try p51Try=new P51Try();
        int n=4;
        List<List<String>> strRes = p51Try.solveNQueens(n);
        strRes.stream().forEach(t->{
            t.stream().forEach(s->{
                System.out.println(s);
            });
            System.out.println();
        });
    }

//    public int totalNQueens(int n) {
//        List<Integer> term=new LinkedList<>();
//        fun(term,0,n);
//        return res;
//    }
}
