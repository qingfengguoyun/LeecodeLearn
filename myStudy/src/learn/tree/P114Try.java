package learn.tree;

import java.util.Stack;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class P114Try {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode r=new TreeNode();
        TreeNode point=r;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if(pop==null){
                continue;
            }
            TreeNode node=new TreeNode(pop.val);
            point.right=node;
            point= point.right;
            if(pop.right!=null){
                stack.push(pop.right);
            }
            if(pop.left!=null){
                stack.push(pop.left);
            }
        }
        root= r.right;
    }

    public static void main(String[] args) {
        P114Try p114Try=new P114Try();

    }
}
