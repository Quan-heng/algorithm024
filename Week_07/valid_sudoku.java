import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class valid_sudoku {
    /**
     * 解题思路：
     * 枚举，行、列、块。看是否有重复元素
     * dfs,bfs都可
     *
     * @param board
     * @return
     */
    public Map<Integer, Set<Character>> rowMap = new HashMap<>();
    public Map<Integer, Set<Character>> colMap = new HashMap<>();
    public Map<Integer, Set<Character>> blockMap = new HashMap<>();

    public boolean isValidSudoku(char[][] board) {
        return dfs(board, 0);
    }

    public boolean dfs(char[][] board, int depth) {
        if (depth == 81) return true;
        int row = depth / 9;
        int col = depth % 9;
        if (board[row][col] == '.') {
            return dfs(board, depth + 1);
        } else {
            char curChar = board[row][col];
            int blockIndex = row / 3 * 3 + col / 3;
            Set<Character> rowSet = rowMap.getOrDefault(row, new HashSet<>());
            Set<Character> colSet = colMap.getOrDefault(col, new HashSet<>());
            Set<Character> blockSet = blockMap.getOrDefault(blockIndex, new HashSet<>());
            if (rowSet.contains(curChar) || colSet.contains(curChar) || blockSet.contains(curChar)) {
                return false;
            } else {
                rowSet.add(curChar);
                colSet.add(curChar);
                blockSet.add(curChar);
                rowMap.put(row, rowSet);
                colMap.put(col, colSet);
                blockMap.put(blockIndex, blockSet);
                return dfs(board, depth + 1);
            }
        }
    }
}
