package javadatastructure.implicitgraph;

import java.util.LinkedList;
import java.util.Queue;

public class implicitGraphDfs {
    static boolean[][] visited;
    static int[][] grid;
    static int rowLength;
    static int colLength;

    public static void main(String[] args) {
        grid = new int[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        rowLength = grid.length;
        colLength = grid[0].length;
        visited = new boolean[rowLength][colLength];
        dfs(0,0);
    }

    public static void dfs(int r, int c) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        visited[r][c] =true;

        for( int i=0; i<4; i++){
            int nextRow = r + dr[i];
            int nectCol = c + dc[i];
            if( rowLength > nextRow && nextRow >= 0 && colLength >nectCol && colLength >=0){
                if(grid[nextRow][nectCol] == 1){
                    if(!(visited[nextRow][nectCol])){
                        dfs(nextRow, nectCol);
                    }
                }
            }
        }
    }
}
