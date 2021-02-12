import java.util.*;
import java.util.concurrent.DelayQueue;

/**
 * 解题思路：回溯，排序，剪枝
 * 相同的元素只排列一次
 */
public class 全排列47 {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 2, 1}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);//有重复元素，需要排序，方便剪枝
        boolean[] used = new boolean[nums.length];
        int depth = 0;
        Deque<Integer> list = new LinkedList<>();
        dfs(nums, list, result, used, depth);
        return result;
    }

    private static void dfs(int[] nums, Deque<Integer> list, List<List<Integer>> result, boolean[] used, int depth) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i - 1 >= 0 && nums[i] == nums[i - 1] && !used[i - 1])) {//剪枝，所有相同元素中，只有第一个参与排列
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, list, result, used, depth + 1);
            used[i] = false;
            list.removeLast();
        }
    }
}
