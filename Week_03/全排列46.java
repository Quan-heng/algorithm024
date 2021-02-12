import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 解题思路：回溯
 * 标记使用过的元素
 */
public class 全排列46 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        boolean[] used = new boolean[nums.length];
        Deque<Integer> list = new LinkedList<>();
        dfs(nums, list, result, 0, used);
        return result;
    }

    private static void dfs(int[] nums, Deque<Integer> list, List<List<Integer>> result, int depth, boolean[] used) {
        //terminator
        if (depth == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        //process
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i]=true;
                //drill down
                dfs(nums,list,result,depth+1,used);
                //回溯
                used[i]=false;
                list.removeLast();
            }
        }
    }
}
