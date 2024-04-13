package javadatastructure.required.ch9Graph;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

//위상정렬문제
public class BOJ14567 {

    static class Pair{
        final Integer subject; //과목 번호
        final Integer semester; //학기

        public Pair(Integer subject, Integer semester){
            this.subject = subject;
            this.semester = semester;
        }
    }
    public static void main(String[] args) {
        //입력 포맷
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int N = Integer.valueOf(s.split(" ")[0]);// 전체 과목 수
        int M = Integer.valueOf(s.split("")[1]); //선수 과목 조건의 수

        // 과목 번호와 매핑 . index -> 과목 번호 ( 0, 과목번호 1), value -> 선수과목 갯수
        int[] indegree = new int[N]; //위상정렬하면서 차수정보 이용
        //key = from node, value = to node <from, to>
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for ( int i=0; i< M; i++){ //M의 크기만큼 for
            s = sc.nextLine();
            //A과목은 B 과목의 선수 과목. A -> B
            int A = Integer.valueOf(s.split("")[0]); //from node
            int B = Integer.valueOf(s.split("")[1]);// to node

            indegree [B -1] +=1;
            List<Integer> l = graph.getOrDefault(A, new ArrayList<>());
            l.add(B);
            graph.put(A, l);
        }
        //위상정렬
        Queue<Pair> queue = new LinkedList<>();
        for ( int i=1; i<indegree.length; i++){
            if(indegree[i - 1] ==0){
                queue.add(new Pair(i, 1)); //괴목번호, 학기
            }
        }

        Integer[] result = new Integer[N]; //결과 출력
        while (queue.isEmpty()){
            Pair p =queue.poll();
            result[p.subject - 1] = p.semester;

            if(graph.containsKey(p.subject)){
                for( Integer node  : graph.get(p.subject)){
                    indegree[node -1] =+1; //edge 제거
                    if(indegree[node -1] ==0){
                        queue.add(new Pair(node, p.semester +1));
                    }
                }
            }
        }
        System.out.println(
                Arrays.asList().stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))
        );
    }
}
