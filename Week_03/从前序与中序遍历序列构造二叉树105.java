/**
 * 解题思路：递归
 * 利用中序遍历计算左子树的边界，从而也可以计算出前序遍历中左、右子树的边界。
 * 将边界值做为递归参数，不断地添加左右子树。
 */
public class 从前序与中序遍历序列构造二叉树105 {
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        buildTree(preorder, inorder);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        if (preorder.length != inorder.length) {
            return null;
        }
        return dfs(0,preorder.length-1,0,inorder.length-1,preorder,inorder);
    }

    private static TreeNode dfs(int preBegin, int preEnd, int inBegin, int inEnd, int[] preorder, int[] inorder) {
       if(preBegin>preEnd||inBegin>inEnd){//左边界大于右边界结束递归
           return null;
       }
       TreeNode root = new TreeNode(preorder[preBegin]);
       int inIndex = 0;
       for(int i=inBegin;i<=inEnd;i++){
           if(inorder[i]==preorder[preBegin])
           {
               inIndex = i; //找到左右子树分界点
               break;
           }
       }
       int preLeftBegin = preBegin+1;
       int preLeftEnd = inIndex-1-inBegin+preLeftBegin;//左子树长度加上左子树起点
       int inLeftBegin = inBegin;
       int inLeftEnd = inIndex-1;
       root.left = dfs(preLeftBegin,preLeftEnd,inLeftBegin,inLeftEnd,preorder,inorder);
       int preRightBegin = preLeftEnd+1;
       int preRightEnd = preEnd;
       int inRightBegin = inIndex+1;
       int inRightEnd = inEnd;
       root.right = dfs(preRightBegin,preRightEnd,inRightBegin,inRightEnd,preorder,inorder);
       return root;
    }

}
