package javadatastructure.required.part6.ch10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//백준 13023 ABCDE
public class DfsBoj13023 {
    static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int N = Integer.valueOf(s.split(" ")[0]); //vertex 사람
        int M = Integer.valueOf(s.split(" ")[0]);// 관계의 수 edge

        //친구의 수 넣어주기
        List<List<Integer>> graph = new ArrayList<>();
        for( int i=0; i<N; i++){
            graph.add(i, new ArrayList<>());
        }

        for( int i=0; i< M; i++){
            s = sc.nextLine();

            int a = Integer.valueOf(s.split(" ")[0]);
            int b = Integer.valueOf(s.split(" ")[1]);

            //친구관계는 양방향
            graph.get(a).add(b);
            graph.get(b).add(a);
            //그래프 초기화 끝
        }

        boolean[] visited = new boolean[N];
        for( int i=0; i< N ; i++){
            dfs(graph,visited,i,1);

            if(found ){
                System.out.println("1");
                return;
            }
        }
        System.out.println("0");
    }
    //dfs 탐색
    static void dfs( List<List<Integer>> graph, boolean[] visited, int v, int depth){
        if ( depth ==5){
            //관계 다 찾음 안해도 돔
            found =true;
            return;
        }
        visited[v] = true; //5가 안되었다면


        //그래ㅠㅡ get으로 v와 연결된 노드 가져옴
        for(int vertex : graph.get(v)){
            if( ! visited[vertex]){
                dfs(graph,visited,vertex, depth +1);
            }
        }
        visited[v] =false;
    }
}
