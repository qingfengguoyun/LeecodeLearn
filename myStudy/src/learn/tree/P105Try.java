package learn.tree;


/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class P105Try {

    public int getIndex(int value,int[] inorder,int il,int ir){
        int i=il;
        while(i<=ir){
            if(inorder[i]==value){
                return i;
            }
            i++;
        }
        return i;
    }

    /**
     * 思路：取先序遍历数组的第一个值，在中序遍历数组中找到该值的位置，并计算该位置左侧和右侧的节点数量，
     * 其左侧和右侧分别为其左子树和又子树，（左侧序列长度，右侧序列长度）
     * 根据统计的数量在先序遍历数组中，从第二位开始，将先序遍历数组依据”左/右侧长度“分为两段
     * 前一段为左侧子树的先序遍历，后一段为右侧子树的先序遍历
     * 最后进行递归处理
     */

    public TreeNode fun (int[] preorder, int pl,int pr,int[] inorder,int il,int ir){
        if(il>ir){
            return null;
        }
        int value=preorder[pl];
        TreeNode treeNode = new TreeNode(value);
        int index = getIndex(value, inorder, il, ir);
        int leftlen=index-il;
        int rightlen=ir-index;
        if(leftlen>0){
            treeNode.left=fun(preorder, pl+1, pl+leftlen, inorder, il, index-1);
        }
        if(rightlen>0){
            treeNode.right=fun(preorder, pr-rightlen+1, pr, inorder, index+1, ir);
        }
        return treeNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode fun = fun(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return fun;
//        Stack<TreeNode> stack=new Stack<>();
    }

    public static void main(String[] args) {
        P105Try p105Try=new P105Try();
        int[] pre=new int[]{3,9,20,15,7};
        int[] in=new int[]{9,3,15,20,7};
        TreeNode treeNode = p105Try.buildTree(pre, in);
        TreeNode.show(treeNode);
    }
}
