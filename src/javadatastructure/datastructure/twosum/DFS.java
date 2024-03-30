package javadatastructure.datastructure.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS {
    static Map< Integer, List<Integer>> graph = new HashMap<>();
    static Map<Integer, Boolean> visited = new HashMap<>();

    public static void main(String[] args) {
        makeGraph();
        dfs(0);
    }

    public static void makeGraph() {
        graph.put(0,Arrays.asList(1,3,6)); //1. 1 방문.
        graph.put(1, Arrays.asList(0, 3));
        graph.put(2, Arrays.asList(3));
        graph.put(3, Arrays.asList(0, 1, 2, 7));
        graph.put(4, Arrays.asList(5));
        graph.put(5, Arrays.asList(4, 6, 7));
        graph.put(6, Arrays.asList(0, 5));
        graph.put(7, Arrays.asList(3, 5));
    }
    //dfs에 curVertex를 넣어 방문하게 되면
    private static void dfs(int curVertex){
        //visited 를 true로 만든다.
        visited.put(curVertex, true);
        //방문을 했으니 나와 연결되어 있는 nextVertex를 방문.
        for( int nextVertex : graph.get(curVertex)){
            //방문 한 적이 없을 때만 방문.
            if(!visited.containsKey(nextVertex)){// 만약 방문한 적이 있는 vertex는 건너뛴다. 방문 하지 않았다면 curVertex로 선정. 이동한다.
                dfs(nextVertex);//재귀를 이용해 방문. 그럼 curVertex가
            }
        }
    }
}
