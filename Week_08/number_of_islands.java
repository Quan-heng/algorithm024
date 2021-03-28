public class number_of_islands {
    private class UnionFind {
        private int _count;
        private int[] _parent;

        public UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            _parent = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        _parent[n * i + j] = n * i + j;
                        _count++;
                    }
                }
            }
        }

        public void Union(int i, int j) {
            int parentI = Find(i);
            int parentJ = Find(j);
            if (parentI == parentJ) return;
            _parent[parentI] = parentJ;
            _count--;
        }

        public int Find(int i) {
            while (_parent[i] != i) {
                _parent[i] = _parent[_parent[i]];
                i = _parent[i];
            }
            return i;
        }

        public int Count() {
            return _count;
        }

    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    //合并上下左右
                    grid[i][j] = '0';
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        uf.Union((i - 1) * n + j, i * n + j);
                    }
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        uf.Union((i + 1) * n + j, i * n + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        uf.Union(i * n + j, i * n + j - 1);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        uf.Union(i * n + j, i * n + j + 1);
                    }
                }
            }
        }

        return uf.Count();
    }
}
