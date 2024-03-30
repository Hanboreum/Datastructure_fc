package javadatastructure.datastructure.twosum;


import java.util.*;

public class BfsDfsTest {

    public static void main(String[] args) {
        makeGraph();
        bfs(0);
        dfs(0);

    }
    public static void makeGraph() {
        graph.put(0, Arrays.asList(1,3,6)); //1. 1 방문.
        graph.put(1, Arrays.asList(0, 3));
        graph.put(2, Arrays.asList(3));
        graph.put(3, Arrays.asList(0, 1, 2, 7));
        graph.put(4, Arrays.asList(5));
        graph.put(5, Arrays.asList(4, 6, 7));
        graph.put(6, Arrays.asList(0, 5));
        graph.put(7, Arrays.asList(3, 5));
    }
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static  Map< Integer, Boolean> visited = new HashMap<>();

    public static void bfs( int start){
        Queue< Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited.put(start, true);
        while (! queue.isEmpty()){
            int curr = queue.poll();
            for( int next : graph.get(curr)){
                if( ! visited.containsKey(next)){
                    queue.offer(next);
                    visited.put(next, true);
                }
            }
        }
    }
    public static void dfs( int curr){
        visited.put(curr, true);
        for (int next : graph.get(curr)){
            if( ! visited.containsKey(next)){
                dfs(next);
            }
        }
    }
}

