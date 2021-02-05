import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的前序遍历144 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        root.right = root1;
        root1.left = root2;
        System.out.println(preorderTraversal(root));
    }

    //递归法
    public static List<Integer> preorderTraversal(TreeNode root){
       List<Integer> result = new ArrayList<>();
       if(root!=null){
           result.add(root.val);
           result.addAll(preorderTraversal(root.left));
           result.addAll(preorderTraversal(root.right));
       }
       return result;
    }
    //跌代法
    public static List<Integer> preorderTraversal1(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null){
            return result;
        }
        stack.push(root);
        TreeNode node;
        while(!stack.empty()){
            node = stack.pop();
            if(node!=null){
                result.add(node.val);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return result;
    }
}
