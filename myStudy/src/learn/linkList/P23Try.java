package learn.linkList;

public class P23Try {


    public ListNode fun(ListNode l1,ListNode l2){
        ListNode root=new ListNode();
        ListNode r=root;
        while(l1!=null||l2!=null){
            if(l1!=null&&l2!=null){
                if(l1.val<l2.val){
                    root.next=new ListNode(l1.val);
                    root=root.next;
                    l1=l1.next;
                }else{
                    root.next=new ListNode(l2.val);
                    root=root.next;
                    l2=l2.next;
                }
            }
            if(l1!=null&&l2==null){
                root.next=new ListNode(l1.val);
                root=root.next;
                l1=l1.next;
            }
            if(l2!=null&&l1==null){
                root.next=new ListNode(l2.val);
                root=root.next;
                l2=l2.next;
            }
        }
        return r.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }
//        ListNode root=lists[0];
//        ListNode r=root;
        //按归并的方式两两合并，比从左到右依次合并效率高

//        for(int i=0;i<lists.length-1;i++){
//            root=fun(root,lists[i+1]);
//        }
        int left=0,right=lists.length-1;
        while(right!=0){
            while(left<=right){
                if(left==right){
                    left += 1;
                    right -= 1;
                }
                else{
                    lists[left] = fun(lists[left], lists[right]);
                    left += 1;
                    right -= 1;
                }
            }
            right=left-1;
            left=0;
        }
        return lists[0];
    }
}
