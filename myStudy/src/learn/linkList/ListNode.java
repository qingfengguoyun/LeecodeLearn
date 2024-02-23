package learn.linkList;

public class ListNode {
     int val;
     ListNode next;
     ListNode() {}

    @Override
    public String toString() {
         ListNode node=this;
         StringBuilder stringBuilder=new StringBuilder();
        while(node!=null){
            stringBuilder.append(node.val+",");
            node=node.next;
        }
        return stringBuilder.toString();
    }

    ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     public static ListNode initListNode (Integer[] array){
         ListNode empHead=new ListNode();
         ListNode point=empHead;
         for(Integer i:array){
             ListNode node = new ListNode(i);
             point.next=node;
             point=node;
         }
         return empHead.next;
     }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
