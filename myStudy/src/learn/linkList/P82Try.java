package learn.linkList;
/**
 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 public class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 */
public class P82Try {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode empHead=new ListNode();
        empHead.next=head;
        ListNode termNode=empHead;
        while(termNode.next!=null){
            ListNode p=termNode.next;
            if(p.next==null){
                termNode.next=p;
                termNode=p;
            }
            else if(p.next!=null&&p.next.val!=p.val){
                termNode=p;
            }else {
                int val=p.val;
                while(p!=null&&p.val==val){
                    p=p.next;
                }
                termNode.next=p;
            }
        }
        return empHead.next;
    }

    public static void main(String[] args) {
        P82Try p82Try=new P82Try();
        Integer[] array=new Integer[]{1,2,3,3,4,4,5};
        ListNode listNode = ListNode.initListNode(array);
        ListNode listNode1 = p82Try.deleteDuplicates(listNode);
        System.out.println(listNode1);
    }
}
