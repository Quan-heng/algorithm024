import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class longest_increasing_subsequence {
    /**
     * 动态规划
     * dp[i],代表0到i之间的最大升序长度
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            result = Math.max(dp[i],result);
        }
        return result;
    }

    /*dfs 会超出时间限制
    public static int maxLength = 0;

    public static int lengthOfLIS(int[] nums) {
        int depth = 0;
        List<Integer> list = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfs(0, list, nums, visited);
        return maxLength;
    }

    private static void dfs(int index, List<Integer> list, int[] nums, Set<Integer> visited) {
        maxLength = Math.max(list.size(), maxLength);
        for (int i = index; i < nums.length; i++) {
            if ((list.isEmpty() || nums[i] > list.get(list.size() - 1)) && !visited.contains(index)) {
                list.add(nums[i]);
                visited.add(index);
                dfs(i + 1, list, nums, visited);
                visited.remove(index);
                list.remove(list.size() - 1);
            }
        }
    }*/

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,4};
        System.out.println(lengthOfLIS(nums));

    }
}
