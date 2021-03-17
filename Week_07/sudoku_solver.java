public class sudoku_solver {
    /**
     * 解题思路：
     * DFS+回溯
     * @param board
     */

    public static void solveSudoku(char[][] board) {
        dfs(board, 0);
    }

    public static boolean dfs(char[][] board, int depth) {
        System.out.println(depth);
        int m = depth / 9;//depth对应的横坐标
        int n = depth % 9;//depth对应的纵坐标
        if ( depth == 81) { //每个元素都dfs一次，当走到第81个元素时，说明数字已填满。
            return true;
        }
        if (board[m][n] == '.') {//当前不是数字，找到合法数字，再进行下次dfs
            for (char c = '1'; c <= '9'; c++) {
                if (isValid(m, n, c, board)) {
                    board[m][n] = c;
                    if (dfs(board, depth + 1)) {//能够一直dfs下去
                        return true;
                    } else {
                        board[m][n] = '.';//回溯
                    }
                }
            }
        } else {
            return dfs(board, depth + 1); //当前是数字，depth加一，直接进入下次dfs
        }
        return false;//当前层找不到一个合适的数字来填充，返回false,前一个元素将会重新置为‘.’
    }

    public static boolean isValid(int m, int n, char c, char[][] board) {
        for(int i=0;i<9;i++){
            int row = m/3*3+i/3;
            int col = n/3*3+ i%3;
            if(board[m][i]==c||board[i][n]==c||board[row][col]==c){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solverSudoku(board);

    }
}
