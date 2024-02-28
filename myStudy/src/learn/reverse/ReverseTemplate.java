package learn.reverse;

import java.util.LinkedList;
import java.util.List;

public class ReverseTemplate {

    List<Object> res=new LinkedList<>();
    public void fun(List<Object> term,List<Object> datas,int index,int endSymbol){
        //
//        if("满足递归终止条件"==true){
//            res.add(term);
//        }
        if(term.size()==endSymbol){
            res.add(term);
        }
        else{
            //对记录下标后的所有值进行递归
            for(int i=index;i<datas.size();i++){
                term.add(datas.get(i));
                //回溯的关键：递归调用时不能访问已经处理过的数据（防止循环）
                //避免重复处理的方式：1，排序 2，记录已处理的内容，并剪枝
                fun(term,datas,i+1,endSymbol);
                //remove即回溯，将递归中进行的操作进行回退，以进行下一次递归
                term.remove(term.size()-1);
            }
        }
    }
}
