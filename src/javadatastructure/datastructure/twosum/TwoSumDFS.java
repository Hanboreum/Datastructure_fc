package javadatastructure.datastructure.twosum;

import java.util.*;

//깊이 우선 탐색
// 더 이상 방문할 곳이 없다면, 직전 상태로 되돌아간다. 그래서 재귀 사용
public class TwoSumDFS {
    public static void main(String[] args) {

/*
        static HashMap<Integer, Boolean> visited = new HashMap<>();

    public static void bfs(Map<Integer, List<Integer>> graph, int startVertex){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex);
        visited.put(startVertex, true);


        while(!queue.isEmpty()){
            int curVertex = queue.poll();
            for(int nextVertex : graph.get(curVertex)){
                if(!visited.containsKey(nextVertex)){
                    queue.offer(nextVertex);
                    visited.put(nextVertex, true);

                }
            }
        }*/
    }

    public static void makeGraph() {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0,Arrays.asList(1,3,6));
        graph.put(1, Arrays.asList(0, 3));
        graph.put(2, Arrays.asList(3));
        graph.put(3, Arrays.asList(0, 1, 2, 7));
        graph.put(4, Arrays.asList(5));
        graph.put(5, Arrays.asList(4, 6, 7));
        graph.put(6, Arrays.asList(0, 5));
        graph.put(7, Arrays.asList(3, 5));
    }

}


/*

package fc.livelecture.datastructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Map<Integer, Boolean> visited = new HashMap<>();
    public static void main(String[] args) {
        initGraph();
        dfs(0);
    }

    private static void initGraph() {
        graph.put(0, Arrays.asList(1, 3, 6));
        graph.put(1, Arrays.asList(0, 3));
        graph.put(2, Arrays.asList(3));
        graph.put(3, Arrays.asList(0, 1, 2, 7));
        graph.put(4, Arrays.asList(5));
        graph.put(5, Arrays.asList(4, 6, 7));
        graph.put(6, Arrays.asList(0, 5));
        graph.put(7, Arrays.asList(3, 5));
    }

    private static void dfs(int node) {
        visited.put(node, true);

        for (Integer cur : graph.get(node)) {
            if (!visited.containsKey(cur)) {
                dfs(cur);
            }
        }
    }
}
그래프 순회란 그래프 탐색이라고도 불린다.
그래프의 각 정점을 방문하는 과정.
깊이 우선 탐색 dept first search , 너비 우선 탐색 Breadth first search 2가지 종류가 있다.

 */
