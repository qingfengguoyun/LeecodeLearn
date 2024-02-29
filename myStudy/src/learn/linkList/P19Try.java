package learn.linkList;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class P19Try {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len=0;
        ListNode root=head;
        while(root!=null){
            len+=1;
            root=root.next;
        }
        ListNode empHead=new ListNode();
        ListNode point=empHead;
        empHead.next=head;
        int m=len-n;
        while(m>0){
            point=point.next;
            m--;
        }
        point.next=point.next.next;
        return empHead.next;
    }

    public static void main(String[] args) {
        P19Try p19Try=new P19Try();
        int[] array=new int[]{1,2,3,4,5};
        ListNode listNode = ListNode.initListNode(array);
        ListNode listNode1 = p19Try.removeNthFromEnd(listNode, 2);
        System.out.println(listNode1);
    }
}
