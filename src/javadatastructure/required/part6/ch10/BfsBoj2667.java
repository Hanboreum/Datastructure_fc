package javadatastructure.required.part6.ch10;

import javax.swing.*;
import java.util.*;

public class BfsBoj2667 {
    static int[][]direction ={
            {-1, 0}, {1,0}, {0,-1}, {0,-1} //좌우상하
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());

        int[][] map = new int[N][N];
        boolean [][]visited = new boolean[][];

        for ( int i=0; i< N; i++){
            String s = sc.nextLine();
            for ( int j=0; j< N; j++){
                map[i][j] = s.charAt(j) -'i';
            }
        }
        List<Integer> result = new ArrayList<>();
        for ( int i=0; i<N; i++){
            for ( int j=0; i< N; j++){
                if (map[i][j] == 1 && ! visited[i][j]){
                    result.add(bfs(N, map, visited, i, j));
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        result.forEach(i -> System.out.println(i));
    }
    public static int bfs( int N, int[][] map, boolean[][] visiteed, int x, int y){
        int size = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        visiteed[x][y] = true;

        while (queue.isEmpty()){
            int[]coordinate = queue.poll();
            for( int i=0; i< 4; i++){
                int nX = coordinate[0] + direction[i][0];
                int nY = coordinate[1] + direction[i][1];

                if(nX >=0 && nY >=0 && nX < N && nY < N
                        && map[nX][nY] ==1 && !visiteed[nX][nY]){
                    size ++;
                    visiteed[nX][nY] = true;
                    queue.add(new int[]{nX, nY});
                }
            }
        }
        return size;
    }
}
