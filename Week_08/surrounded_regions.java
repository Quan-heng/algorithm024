public class surrounded_regions {
    private class UnionFind {
        private int[] _parent;

        public UnionFind(int totalCount) {
            _parent = new int[totalCount];
            for (int i = 0; i < totalCount; i++) {
                _parent[i] = i;
            }
        }


        public void Union(int p, int q) {
            int parentP = Find(p);
            int parentQ = Find(q);
            if (parentP != parentQ) {
                _parent[parentQ] = parentP;
            }
        }

        public int Find(int i) {
            while (_parent[i] != i) {
                _parent[i] = _parent[_parent[i]];
                i = _parent[i];
            }
            return i;
        }

        public boolean IsConnected(int i, int j) {
            return Find(i) == Find(j);
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        UnionFind uf = new UnionFind(m * n + 1);
        int bj = m * n;//虚拟点，让边界为‘O’的点与该点相连
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //检查相连的'O'是否到达边界
                if (board[i][j] == 'O') {
                    int cur = i * n + j;
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        uf.Union(cur, bj);
                    } else {
                        if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                            uf.Union((i - 1) * n + j, cur);
                        }
                        if (i + 1 <= m - 1 && board[i + 1][j] == 'O') {
                            uf.Union((i + 1) * n + j, cur);
                        }
                        if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                            uf.Union(i * n + j - 1, cur);
                        }
                        if (j + 1 <= n - 1 && board[i][j + 1] == 'O') {
                            uf.Union(i * n + j + 1, cur);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!uf.IsConnected(i * n + j, bj)) {
                    board[i][j] = 'X';
                } else {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
