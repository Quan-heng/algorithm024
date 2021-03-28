#1.Trie树模板
```
    private static int size;
    private static int count;

    private static void solve(int row, int ld, int rd,int depth) {
        if (row == size) {
            count++;
            System.out.println("------------------" + count);
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
```
#2.并查集模板
```
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
```