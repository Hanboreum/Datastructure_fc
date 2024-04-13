package javadatastructure.required.ch9Graph;

import com.sun.source.tree.IfTree;

import javax.swing.*;
import java.util.*;

public class GraphAlgorithms {
    // 결과값: 방문한 노드를 순서대로 저장한 List,    input: 구현한 그래프 타입, 시작 노드 위치
    public static List< Integer> bfs( IGraph iGraph, int from){
       //연산을 도와주는 자료구조 초기화
        List<Integer> result = new ArrayList<>(); //최종 아웃풋 결과 출력
        Set<Integer> visited = new HashSet<>();  //노드 재방문 방지, 무한 루프 방지
        Queue<Integer> queue = new LinkedList<>();

       //queue에 시작노드인 from 을 넣어주면서 bfs 방문
        queue.add(from);// 시작 노드 위치를 넣어줌
        visited.add(from); // 위에서 from 위치를 방문했기에 방문처리.

        while( queue.isEmpty()){//큐가 빌 때 까지.
            Integer next = queue.poll();  //next로 큐의 데이터를 가져옴
            result.add(next); //next 노드 방문.

            //next 노드를 방문 했다면 next 노드에 연결된 노드들을 queue에 넣어줘야함
            for (Integer n: iGraph.getNodes(next)) { //이때 visitedd인, 이미 방문한 노드는 다시 넣어주면 안됨
                if(visited.contains(n)){ //중복 검사
                    queue.add(n);
                    visited.add(n);
                }
            }
        }
        return result; //방문 결과값 출력
    }
}

class test{
    public List<Integer> bfs2(IGraph iGraph, int from){
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(from);
        visited.add(from);

        while (queue.isEmpty()){
            Integer next = queue.poll();
            result.add(from);
            for ( Integer n : iGraph.getNodes(next)){
                if(visited.contains(n)){
                    queue.add(n);
                    visited.add(n);
                }
            }
        }
        return result;
    }

    public static void bfs3( IGraph iGraph,int from){
        Queue< Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(from);
        visited.add(from);
        while(! queue.isEmpty()){
            int curr = queue.poll();
            for( int next : iGraph.getNodes(curr)){
                if( ! visited.contains(curr)){
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
    }
}