package learn;

import java.util.*;

public class P150Try {

    public int evalRPN(String[] tokens) {
        Stack<Integer> nums=new Stack<>();
        Stack<String> signals=new Stack<>();
        List<String> singal = Arrays.asList("+", "-", "*", "/");
        for(String str:tokens){
            try{
                Integer num = Integer.valueOf(str);
                nums.push(num);
            }catch (Exception e){
                Integer num1=nums.pop();
                Integer num2=nums.pop();
                int i = singal.indexOf(str);
                if(i==0){
                    nums.push(num1+num2);
                }
                if(i==1){
                    nums.push(num2-num1);
                }
                if(i==2){
                    nums.push(num1*num2);
                }
                if(i==3){
                    nums.push(num2/num1);
                }
            }
        }
        return nums.pop();
    }

    public static void main(String[] args) {
        P150Try p150Try=new P150Try();
        String[] tokens=new String[]{"4","13","5","/","+"};
        System.out.println(p150Try.evalRPN(tokens));
    }
}
