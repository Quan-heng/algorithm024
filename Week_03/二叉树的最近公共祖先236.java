/**
 * 解题思路：递归
 * 1.左右节点落在父结点两侧，返回上级节点
 * 2.都在同一侧，返回两节点中的最上层的结点
 */
public class 二叉树的最近公共祖先236 {
    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //terminator
        if(root==null){
            return null;
        }
        if(p==root||q==root){
            return root;
        }
        //process,drill down
        TreeNode left  = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left==null){ //在左子树没有找到p,q
            return right;
        }
        if(right==null){//在右子树没有找到p,q
            return left;
        }
        return root;
        //reverse
    }
}
