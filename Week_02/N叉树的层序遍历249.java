import java.util.*;

public class N叉树的层序遍历249 {
    //思路，从上到下，从左到右，用queue保存每一层node,依次取出队首值
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> subList;
        while (!queue.isEmpty()) {
            subList = new ArrayList<>();
            Queue<Node> subQueue = new LinkedList<>();
            while (!queue.isEmpty()){
                Node node = queue.remove();
                subList.add(node.val);
                if (node.children != null) {
                    subQueue.addAll(node.children);
                }
            }
            result.add(subList);
            queue = subQueue;

        }
        return result;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.children = new ArrayList<>();
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.children.add(node2);
        node1.children.add(node3);
        node1.children.add(node4);
        node2.children = new ArrayList<>();
        node2.children.add(node5);
        node2.children.add(node6);
        System.out.println(levelOrder(node1));
    }

}
