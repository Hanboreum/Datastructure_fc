package javadatastructure.required.ch9Graph;

import java.util.*;
//2차원 배열의 인접 행렬 방식
public class AdjacencyMatrixGraph implements  IGraph{

    private Integer[][] matrix; //그래프의 연결 정보를 관리
    private Set<Integer> vertexes; //그래프 버텍스의 정보
    private Map<Integer, Integer> indegrees; //그래프의 차수 정보를 가지고 있음
    //3번 노드를 가리키고 있는 노드가 총 3개일 때,
    // indegrees.get(3) 을 하면 5이 나온다.
    //노드 3을 가리키는 노드의 개수가 5개라는 것을 의미


    public AdjacencyMatrixGraph( int numOfVertex){
        //버텍스의 개수를 파라미터로 입력 받음
        this. vertexes = new HashSet<>();
        this.indegrees = new HashMap<>();
        this.matrix = new Integer[numOfVertex][]; //파라미터로 입력 받은 개수 만큼 matrix를 초기화 해준다.
        for( int i=0; i< numOfVertex; i++){
            this.matrix[i] = new Integer[numOfVertex];
        }
    }
    @Override
    public void add(int from, int to) {
        this.vertexes.add(from);
        this.vertexes.add(to);
        int count = this.indegrees.getOrDefault(to, 0);
        indegrees.put(to, count +1);
        matrix[from][to] = 1; //distance를 입력 받지 않기 때문에 1

        //matrix[from][to] = null; 추가시 from 과 to 노드간 연결 관계가 끊어졌다.
    }

    @Override
    public void add(int from, int to, Integer distance) {
        //입력으로 from, to 가 들어오면 노드 정보를 추가해줘야함
        this.vertexes.add(from);
        this.vertexes.add(to);
        //set은 중복값을 저장하지 않기 때문에 이미 from, to가 있다면 저장하지 않음
        int count = this.indegrees.getOrDefault(to, 0); // to 값이 있다면 to  쓰고, 없다면 0
        indegrees.put( to,count+ 1);// 현재 정보에 +1 을 해주고 개수 정보 저장

        //매트릭스 베텍스 간의 연결 정보(from, to의 언결 정보 추가) 저장
        matrix[from][to] = distance; //from, to가 우리가 입력받은 distance 정보로 연결됨.
    }

    @Override
    public Integer getDistance(int from, int to) {
        return this.matrix[from][to];
    }

    @Override
    public Map<Integer, Integer> getIndegrees() {
        return this. indegrees;
    }

    @Override
    public List<Integer> getNodes(int vertex) {
        List<Integer> result = new ArrayList<>(); // 결과 출력 하기 위한
        for ( int i =0; i< this.matrix[vertex].length; i++){
            if( this.matrix[vertex][i] != null){ //버텍스가 from 이 되고, i 가 to 가 됨.
                result.add(i);
            }
        }
        return result;
    }

    @Override
    public Set<Integer> getVertexes() {
        return this.vertexes;
    }
}
