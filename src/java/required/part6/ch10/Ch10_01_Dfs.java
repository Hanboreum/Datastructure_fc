package java.required.part6.ch10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ch10_01_Dfs {
    static int[][] direction ={
            //좌, 우, 상 ,하
            {-1,0},{1,0},{0,-1},{0,1}
    };
    //단지의 크기.
    static int size =0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());
        //지도는 N * N 사이즈를 가지고 있기 때문
        int[][]map = new int[N][N];
        //방문 여부 확인.
        boolean[][] visited = new boolean[N][N];

        //N크기만큼 지도를 입력받아 0,1로 지도를 채워줌
        for( int i=0; i<N; i++){
            String s = sc.nextLine();
            for(int j=0; j < N; j++){
                //하나씩 쪼개서 지도에 넣어줘야하는데, 그대로 지도에 넣게 되면 아스키 코드 값이 들어감
                // -0을 해서 0,1 값으로 넣어줌
                map[i][j] = s.charAt(j)-'0';
            }
        }
        //input으로 지도 초기화 끝냄.

        //
        List<Integer> result = new ArrayList<>();

        //이중배열, 이중포문
        for(int i=0; i< N; i++){
            for(int j=0; j< N; j++){
                //map i,j에 값이 1이라는 것은 해당 위치에 집이 있다는 것
               if(  map[i][j] == 1 && visited [i][j]){
                   size = 1;
                   //dfs 에 파라미터 넣어서 탐색해줌
                   dfs(N, map, visited, i, j);
                   //dsf탐색이 종료된 시점의 size 값을 result 에 넣어줌
                   result.add(size);
               }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        result.forEach(i -> System.out.println(i));
    }
    //dfs탐색에 필요한 지도의 크기 N, map의 데이터 맵, 방문 여부 visited, 현재 좌표값 x,y를 받는다
    public static void dfs(int N, int [][]map, boolean[][]visited, int x, int y){
        //현재 받은 x,y는 visited 체크 해 줌
        visited[x][y] = true;
        //인접한 상하좌우 확인
        for( int i=0; i< direction.length ; i++){
            //상하좌우 이동된 새로운 x, y좌료값 얻고
            int nX = x + direction[i][0];
            int nY = y + direction[i][1];
        //이 좌표가 지도상에서 가능한 좌표인지 확인 해봐야 함. 0보다 크고 n보다 작아야 함
            //이렇게 하면 인접한 집이 있고, 아직 방문하지 않은 집을 찾은 것.
            if( nX >=0 && nY >= 0 && nX < N && nY < N && map[nY][nX] ==1 && !visited[nY][nX]){
               //찾은 집을 +1 해줌
                size +=1;
                //새로 발견한 nx, ny기준으로 계속해서 영역 확장이 가능한지
                //dfs 검색
                //더 이상 연결 가능한 집이 없다면 종료
                dfs(N, map, visited,nX, nY);
            }
        }
    }
}
