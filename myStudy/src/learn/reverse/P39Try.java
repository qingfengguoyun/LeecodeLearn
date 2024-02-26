package learn.reverse;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class P39Try {

    List<List<Integer>> res=new LinkedList<>();
//    Integer index=0;

    public void fun(List<Integer> term,int[] datas,int index,int target){
        if(target==0){
            res.add(term.stream().collect(Collectors.toList()));
        }else if(target<0){

        }else{
            for(int i=index;i<datas.length;i++){
                term.add(datas[i]);
                target-=datas[i];
                fun(term,datas,i,target);
                target+=datas[i];
                term.remove(term.size()-1);
                if(target-datas[i]<=0){
                    break;
                }
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //使candidates有序，以添加循环跳出条件，减少循环次数
        Arrays.sort(candidates);
        List<Integer> term=new LinkedList<>();
        fun(term,candidates,0,target);
        return res;
    }

    public static void main(String[] args) {
        P39Try p39Try=new P39Try();
        int[] candidates=new int[]{8,7,4,3};
        int target=11;
        Arrays.sort(candidates);
        List<List<Integer>> res = p39Try.combinationSum(candidates, target);
        res.stream().forEach(t->{
            t.stream().forEach(k->{
                System.out.print(String.format("%d ",k));
            });
            System.out.println();
        });
    }
}
