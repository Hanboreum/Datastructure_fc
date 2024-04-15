package javadatastructure.implicitgraph;

import java.util.LinkedList;
import java.util.Queue;

public class implicitGraphBfs {
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
        bfs(0,0);

    }
        public static void bfs( int r, int c){
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{r,c});
            int[] dr = {0,1,0,-1};
            int []dc = {1,0,-1,0};
            visited[r][c] = true;

            while (!queue.isEmpty()){
                int []curr = queue.poll();
                int curRow = curr[0];
                int curCol = curr[1];

                for( int i=0; i< 4; i++){
                    int nextRow = curRow + dr[i];
                    int nextCol = curCol + dc[i];
                    if( rowLength > nextRow && nextRow >= 0 && colLength > nextCol&& nextCol >= 0){
                        if(grid[nextRow][nextCol] == 1){
                            if(!(visited[nextRow][nextCol])){
                                visited[nextRow][nextCol] =true;
                                queue.offer(new int [] {nextRow, nextCol});
                            }
                        }
                    }
                }
            }
        }
    }

