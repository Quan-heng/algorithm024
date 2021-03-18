import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路：
 * dfs+剪枝
 */
public class generate_parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        dfs(result, left, right, n, "");
        return result;
    }

    private void dfs(List<String> result, int left, int right, int n, String s) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }
        if (left < n) dfs(result, left + 1, right, n, s + "("); //剪枝
        if (right < left) dfs(result, left, right + 1, n, s + ")");
    }
}
