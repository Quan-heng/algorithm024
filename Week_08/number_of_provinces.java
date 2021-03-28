public class number_of_provinces {
    private class UnionFind{
        private int _count;
        private int[] _parent;
        public UnionFind(int n){
            _parent = new int[n];
            for(int i=0;i<n;i++){
                _parent[i] = i;
                _count++;
            }
        }

        public void Union(int i, int j){
            int parentI =Find(i);
            int parentJ = Find(j);
            if(parentI==parentJ) return;
            _parent[parentI] = parentJ;
            _count--;
        }

        public int Find(int i){
            while(_parent[i]!=i){
                _parent[i] = _parent[_parent[i]];
                i = _parent[i];
            }
            return i;
        }

        public int Count(){
            return _count;
        }

    }
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        UnionFind uf = new UnionFind(len);
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(isConnected[i][j]==1){
                    uf.Union(i,j);
                }
            }
        }

        return uf.Count();
    }
}
