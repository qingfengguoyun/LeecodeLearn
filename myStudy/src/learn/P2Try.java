package learn;

import javax.swing.*;
import java.util.Stack;

public class P2Try {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=new ListNode();
        ListNode head=res;
        ListNode pre=res;
        int n=0,add=0;
        while(l1!=null||l2!=null){
            int i=l1!=null?l1.val:0;
            int j=l2!=null?l2.val:0;
            n=(i+j+add)%10;
            add=(i+j+add)/10;
            res.val=n;
            res.next=new ListNode();
            pre=res;
            res=res.next;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(add==1){
            res.val=1;
        }
        else{
            pre.next=null;
        }
        return head;
    }

    public static void main(String[] args) {
        P2Try p2Try=new P2Try();

    }

}
