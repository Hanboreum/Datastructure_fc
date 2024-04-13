package javadatastructure.required.ch9Graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IGraph {
    void add( int from, int to); //1,3 연결되어 있다면 1 = from, 3 = to넣어서 add호출
    void add( int from, int to, Integer distance); //distance = 가중치 변수. 엣지마다 가중치가 다른 그래프의 경우 노드 정보 추가
    Integer getDistance( int from, int to); // from 에서 to 까지 가중치를 가져오는 메소드
    Map<Integer, Integer> getIndegrees(); //그래프 상 모든 버텍스의 갯수를 맵으로 가져오는 메소드. key 값은 node, value 은 Indgree
    Set<Integer> getVertexes =null; // 그래프상 존재하는 모든 버텍스의 집합을 찾아줌
    List<Integer> getNodes(int vertex); //노드에서 나가는 out degree가 가리키고 있는 노트들의 집합을 리스트로 반환해줌
    Set<Integer> getVertexes();
}
