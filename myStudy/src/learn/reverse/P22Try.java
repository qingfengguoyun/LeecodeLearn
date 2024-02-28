package learn.reverse;

import java.util.LinkedList;
import java.util.List;

public class P22Try {
    
    List<String> res=new LinkedList<>();
    
    public void fun(StringBuilder builder,int[] remain,int n){
        if(builder.length()==n*2){
            res.add(builder.toString());
        }else{
            //需保证左括号剩余数量少于等于右括号
            if(remain[0]>0){
                remain[0]-=1;
                builder.append("(");
                fun(builder,remain,n);
                builder.deleteCharAt(builder.length()-1);
                remain[0]+=1;
            }
            if(remain[1]>remain[0]&&remain[1]>=0){
                remain[1]-=1;
                builder.append(")");
                fun(builder,remain,n);
                builder.deleteCharAt(builder.length()-1);
                remain[1]+=1;
            }
        }
    }
    
    public List<String> generateParenthesis(int n) {
        int[] remain=new int[2];
        remain[0]=n;remain[1]=n;
        StringBuilder builder = new StringBuilder();
        fun(builder,remain,n);
        return res;
    }

    public static void main(String[] args) {
        P22Try p22Try=new P22Try();
        int n=3;
        List<String> strings = p22Try.generateParenthesis(n);
        for(String str:strings){
            System.out.println(str);
        }
    }
    
}
