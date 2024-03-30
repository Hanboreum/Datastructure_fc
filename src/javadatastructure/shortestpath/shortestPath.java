package javadatastructure.shortestpath;

import java.util.LinkedList;
import java.util.Queue;

public class shortestPath {

}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;// 시작 지점 방문 처리
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0}); //큐에 시작 지점에 좌표 추가
        int length = 1;
        while (!queue.isEmpty()) {// 큐가 비어있지 않은 동안
            int size = queue.size();
            for (int i = 0; i < size; i++) {// 큐의 사이즈만큼 반복

            }
        }
        return m;
    }
}

class Array<T>{
    T element;
    void setElement(T element){
        this. element = element;
    }
    T getElement(){ return element; }

}
