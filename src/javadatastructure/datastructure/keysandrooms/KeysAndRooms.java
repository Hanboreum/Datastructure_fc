package javadatastructure.datastructure.keysandrooms;

import javax.swing.*;
import java.util.*;

public class KeysAndRooms {

}
class KeyAndRoomsBfs{
    public boolean canVisitAllRooms(List<List<Integer>> rooms){
        boolean[]visited = new boolean[rooms.size()];
       bfs(rooms, visited, 0);
       for ( int i=0; i < visited.length; i++){
           if(!visited[i]){
               return  false;
           }
       }
       return  true;
    }
    public void bfs( List<List<Integer>> rooms, boolean[] visited, int v){
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.offer(v);
        while (!queue.isEmpty()){
            int curr =queue.poll();
            for(Integer next : rooms.get(curr)){
                if( visited[next] == false){
                    queue.offer(next);
                    visited[next] = true ;
                }
            }
        }
    }
}

class KeysAndRoomsDfs{
    static boolean[] visited;
   public boolean canVisitAllRooms(List<List<Integer>> rooms){
       visited = new boolean[rooms.size()];
       dfs(rooms, 0);

       for( int i=0; i< visited.length; i++){
           if(!visited[i]){
               return false;
           }
       }
       return true;
   }
   public void dfs(List<List<Integer>> rooms, int v){
       visited[v] = true;
       for( Integer next : rooms.get(v)){
               if(visited[next] ==false){
                   dfs(rooms,next);
           }
       }
   }
}