import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n_queens {
    public static char[][] board;
    public static boolean[] colFlag;
    public static boolean[] pieFlag;
    public static boolean[] naFlag;

    public static List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        colFlag = new boolean[n];
        pieFlag = new boolean[n*2];
        naFlag = new boolean[n*2];
        List<List<String>> result = new ArrayList<>();
        dfs(board,result,0);
        return result;
    }

    private static void dfs(char[][] board, List<List<String>> result, int depth) {
        if (depth == board.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<board.length;j++){
                    sb.append(board[i][j]);
                }
                list.add(sb.toString());
            }
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if(colFlag[i]||pieFlag[depth+i]||naFlag[depth-i+board.length-1]) continue;
            colFlag[i] = true;
            pieFlag[depth + i] = true;
            naFlag[depth - i+board.length-1] = true;
            board[depth][i]= 'Q';
            dfs(board, result, depth + 1);
            colFlag[i] = false;
            pieFlag[depth + i] = false;
            naFlag[depth - i+board.length-1] = false;
            board[depth][i]= '.';
        }
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(8));
    }
}
