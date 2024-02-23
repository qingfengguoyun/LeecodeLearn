package learn.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public static List<Integer> toList(TreeNode node){
          List<Integer> res=new LinkedList<>();
          Queue<TreeNode> quere=new LinkedList<>();
          quere.add(node);
          while(!quere.isEmpty()){
              TreeNode n = quere.poll();
              if(n==null){
                  res.add(null);
                  continue;
              }else{
                  res.add(n.val);
                  quere.add(n.left);
                  quere.add(n.right);
              }
          }
          return res;
    }

    public static void show(TreeNode node){
        List<Integer> list = toList(node);
        list.stream().forEach(t->{
            if(t!=null){
                System.out.println(t+" ");
            }else{
                System.out.println("null"+" ");
            }
        });
    }

}
