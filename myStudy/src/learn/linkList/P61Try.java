package learn.linkList;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class P61Try {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode point=head;
        Integer len=0;
        while(point!=null){
            len+=1;
            point=point.next;
        }
        if(len==0||len==1){
            return head;
        }
        ListNode empHead=new ListNode();
        empHead.next=head;
        ListNode p=empHead;
        int i=len-(k%len);
        while(i>0){
            p=p.next;
            i--;
        }
        ListNode p2=p.next;
        p.next=null;
        if(p2!=null){
            empHead.next=p2;
            while(p2.next!=null){
                p2=p2.next;
            }
            p2.next=head;
            return empHead.next;
        }else{
            return head;
        }

    }

    public static void main(String[] args) {
        P61Try p61Try=new P61Try();
        Integer[] array=new Integer[]{1,2};
        ListNode listNode = ListNode.initListNode(array);
        ListNode listNode1 = p61Try.rotateRight(listNode,0);
        System.out.println(listNode1);
    }
}
