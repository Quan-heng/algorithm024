import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的中序遍历94 {
    //方法1，递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.addAll(inorderTraversal(root.left));
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }

    //方法2：迭代，stack,左中右 ，入栈，右中左。依次弹出。
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root !=null||!stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root= root.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root3 = new TreeNode(4);

        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        root.right = root1;
        root.left = root2;
        root3.left = root;
        System.out.println(inorderTraversal2(root3));

    }
}
