package javadatastructure.required.ch9Graph;

import org.w3c.dom.Node;

import java.util.*;
//인접리스트는 베텍스의 개수 만큼 리스트를 사용해 그래프의 연결 정보를 표현한다.
public class AdjacencyListGraph implements IGraph{

    private List<List<Node>> graph; //버텍스의 개수 만큼 사용할 리스트를 멤버면수로 생성
    //바깥 리스트의 인덱스 번호가 node의 번호가 된다.
    private Set<Integer> vertexs; //버텍스 정보
    private Map<Integer, Integer> indegrees; // 차수 정보

    public AdjacencyListGraph( int numOfVertex){ //생성자서 버텍스의 정보를 파라미터로 초기화
        this.vertexs = new HashSet<>();
        this.indegrees = new HashMap<>();
        this.graph = new ArrayList<>(numOfVertex);// 버텍스의 개수 만큼 그래프의 리스트 초기화
        for( int i=0; i< numOfVertex; i++){
            this.graph.add(new ArrayList<>());
        }
    }
    @Override
    public void add(int from, int to) {
        vertexs.add(from);
        vertexs.add(to);
        int count = indegrees.getOrDefault(to, 0);
        indegrees.put(to, count +1);
        List<Node> neighbors = this.graph.get(from);
        neighbors.add(new Node(from, to));
    }

    @Override
    public void add(int from, int to, Integer distance) {
        vertexs.add(from);
        vertexs.add(to);

        int count = indegrees.getOrDefault(to, 0);
        indegrees.put(to, count + 1); // 차수 개수 정보가 나온다.

        //바깥 리스트의 인덱스 번호가 node의 번호가 된다.
        // 0 ->[1,2,3,] , 0번째 노드는 1,2,3 번째 노드를 가리키고 있다.
        // 1 ->[2] //1번째 노드는 2번 노드를 가리킴
        // 2 ->[0,1], 0,1번쨰 노드
        // 3 ->[] //아무것도

        //그래프에 노드 이름을 넣으면 해당 노드가 가리키고 있는 노드들을 가져오게 된다.
        List<Node> neighbors = this.graph.get(from);
        neighbors.add(new Node(from, to, distance)); //연결 정보 추가
    }

    @Override
    public Integer getDistance(int from, int to) {
        //from과 to의 연결을 가져와야함
        for( Node node : this.graph.get(from)){ //from 이 가리키고 있는 노드가 나온다.
            if ( node.to.equals(to)){ //node의 to가 입력받은 to와 같다면
                return node.weight;
            }
        }
        return null; //연결이 없다면 null 반환
    }

    @Override
    public Map<Integer, Integer> getIndegrees() {
        return this.indegrees;
    }

    @Override
    public List<Integer> getNodes(int vertex) {
        List<Integer> nodes = new ArrayList<>();
        for(Node node: this.graph.get(vertex)){
            nodes.add(node.to);
        }
        return nodes;
        //파라미터로 입력받은 vertex가 가리키고 있는 노드 정보를 출력
    }

    @Override
    public Set<Integer> getVertexes() {
        return this.vertexs;
    }
    private class Node{ //Node inner class 생성
        //출발, 도착 , 가중치 정보를 변수로 가지고 있다.
        Integer from;
        Integer to;
        int weight;

        Node( int from, int to){
            this.from = from;
            this.to = to;
            this.weight = 1;
        }
        Node( int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
