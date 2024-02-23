package learn;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class MinStack {

    List<Integer> data;
    Integer size;

    public MinStack() {
        data=new LinkedList<Integer>();
        size=0;
    }

    public void push(int val) {
        data.add(size,val);
        size+=1;
    }

    public void pop() {
        if(size>=0){
            data.remove(size-1);
            size-=1;
        }
    }

    public int top() {
        return data.get(size-1);
    }

    public int getMin() {
        return Collections.min(data);
    }
}
public class P155Try {


    public static void main(String[] args) {
        P155Try p155Try=new P155Try();
        MinStack stack=new MinStack();
        stack.push(123);
        stack.push(33);
        stack.push(32);
        System.out.println(stack.getMin());
    }

}
