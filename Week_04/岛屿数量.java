/**
 * 解题思路：DFS，将‘1’周围(上下左右)的‘1’标记为‘0’,一直到所有的元素都为0
 */
class 岛屿数量 {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if(n==0){
            return 0;
        }
        int m = grid[0].length;
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(i,j,n,m,grid);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j,int n,int m, char[][] grid) {
        if(i<0||i>n-1||j<0||j>m-1||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        dfs(i-1,j,n,m,grid);//left
        dfs(i+1,j,n,m,grid);//right
        dfs(i,j-1,n,m,grid);//up
        dfs(i,j+1,n,m,grid);//down
    }
}
