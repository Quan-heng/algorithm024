public class n_queens_ii {
    private static int size;
    private static int count;

    private static void solve(int row, int ld, int rd,int depth) {
        if (row == size) {
            count++;
            return;
        }
        int pos = size & (~(row | ld | rd));
        while (pos != 0) {
            int p = pos & (-pos);
            pos = pos & (pos - 1);
            solve(row | p, (ld | p) << 1, (rd | p) >> 1,depth+1);
        }
    }

    public static int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        solve(0, 0, 0,0);
        return count;
    }
}
