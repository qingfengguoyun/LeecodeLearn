package learn.linkList;

import java.util.Arrays;
import java.util.List;

//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
public class P148Try {

    public ListNode sortList(ListNode head) {
        ListNode root=new ListNode();
        ListNode r=root;
        while(head!=null){
            ListNode term=root;

            while(term.next!=null){
                if(term.next.val>head.val){
                    break;
                }
                term=term.next;
            }
            ListNode next=term.next;
            term.next=new ListNode(head.val);
            term.next.next=next;
            head=head.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 2, 1, 3,6,8,9);
        ListNode listNode = ListNode.initListNode(new int[]{4, 2, 1, 3,6,8,9});
        P148Try p148Try=new P148Try();
        ListNode res = p148Try.sortList(listNode);
        ListNode.print(res);
    }

}
