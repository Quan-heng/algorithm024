

import java.util.Arrays;

/**
 * 扫雷游戏
 * 解题思路：DFS，
 * 1.如果周围无雷则往下递归，如果是数字停止递归
 * 2.如果是雷，直接返回
 */
public class 打雷游戏 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int[] click  = new int[]{1,2};
        System.out.println(updateBoard(board,click));
    }
    public static char[][] updateBoard(char[][] board, int[] click) {
        int height  = board.length;
        int width = board[0].length;
        int x = click[0];
        int y = click[1];
        dfs(x,y,height,width,board);
        return board;
    }

    private static void dfs(int x, int y, int height,int width,char[][] board) {
        if(board[x][y]=='M'){
            board[x][y]='X';
            return;
        }
        //检查周围8个点有没有雷
        if(board[x][y]=='E'){
            int count = 0;
            for(int i = x-1;i<=x+1;i++){
                for(int j = y-1;j<=y+1;j++){
                    if(i<0||i>height-1||j<0||j>width-1||(x==i&&y==j)){
                        continue;
                    }
                    if(board[i][j]=='M'){
                        count++;
                    }
                }
            }
            if(count>0){//周围有雷，标记数字，终止递归
                board[x][y] = (char)('0'+count);
                return;
            }else{ //周围无雷，向周围递归
                board[x][y] = 'B';
                for(int i = x-1;i<=x+1;i++){
                    for(int j = y-1;j<=y+1;j++){
                        if(i<0||i>height-1||j<0||j>width-1||(x==i&&y==j)||board[i][j]!='E'){//标记过了就不需要向下递归了
                            continue;
                        }
                        dfs(i,j,height,width,board);
                    }
                }
            }
        }
    }
}
