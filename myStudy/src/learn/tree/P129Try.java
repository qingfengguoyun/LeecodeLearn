package learn.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 */
public class P129Try {
    


    public int sumNumbers(TreeNode root) {
        int sum=0;
        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node==null){
                continue;
            }
            if(node.left==null&&node.right==null){
                sum+=node.val;
            }
            else{
                if(node.right!=null){
                    node.right.val+=node.val*10;
                    stack.push(node.right);
                }
                if(node.left!=null){
                    node.left.val+=node.val*10;
                    stack.push(node.left);
                }
            }
        }
        return sum;
    }
}
