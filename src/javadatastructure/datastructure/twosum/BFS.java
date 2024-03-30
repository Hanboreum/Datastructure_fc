package javadatastructure.datastructure.twosum;

import java.util.*;
//깊이 우선 탐색
//가까운곳부터 방문. fifo. 큐를 이용하면 dfs 구현 가능.
//큐를 이용해 예약.
//너비우선 탐색은 출발점서 가까운 곳을 먼저 간다. 그래서 큐 fifo를 사용한다.
public class BFS {
    public static void main(String[] args) {
        makeGraph();
        bfsTest(0);
    }
/*

    static HashMap visited = new HashMap<>();

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
        }
    }

 */
     public static void makeGraph() {
         graph.put(0,Arrays.asList(1,3,6));
         graph.put(1, Arrays.asList(0, 3));
         graph.put(2, Arrays.asList(3));
         graph.put(3, Arrays.asList(0, 1, 2, 7));
         graph.put(4, Arrays.asList(5));
         graph.put(5, Arrays.asList(4, 6, 7));
         graph.put(6, Arrays.asList(0, 5));
         graph.put(7, Arrays.asList(3, 5));
    }

    //암기.. bfs, dfs 둘 다
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Map<Integer, Boolean> visited1 = new HashMap<>();
    public static void bfsTest(int startVertex){
        //큐로 linkedlist 만들기
        Queue<Integer> queue = new LinkedList<>();
        //0번 노드를 예약
        queue.offer(startVertex);
        //방문했다면 표시 true
        visited1.put(startVertex, true);

        //poll 을 해서 방문. 1,3,6 하나씩 살펴봄.
        //큐 한 줄 방문이 끝나면 다시 while문으로 들어간다.
        while(! queue.isEmpty()){
            //! 가 없다면, 큐가 비어 있으먼 while을 계속 돌겠다.
            //큐가 비어있으면 true, 비어있는 한 반복 계쏙
            //우리의 목표는 안비어있으면 계쏙 도는 것
            //비어있지 않는 한 계속 돈다.
            //큐가 비어있을 때 반복문 종료.

            //큐의 맨 앞부분을 방문하는 코드
            int curVertex = queue.poll();
            for(int nextVertex : graph.get(curVertex)){
                //containsKey 방문한적이 있나없나
                if( ! visited1.containsKey(nextVertex)){
                    //방문한적 없다면 예약
                    queue.offer(nextVertex);
                    //예약하자마자 방문표시 true
                    visited1.put(nextVertex, true);
                }
            }
        }
    }
}


