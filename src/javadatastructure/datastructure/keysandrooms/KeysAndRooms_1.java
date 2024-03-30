package javadatastructure.datastructure.keysandrooms;

import java.util.ArrayList;
import java.util.List;

public class KeysAndRooms_1 {

    public boolean VisitedAllRooms(List<List<Integer>> rooms){
        List<Integer> visited = new ArrayList<>();

        recursiveVisited(visited, rooms, 0);
        if( visited.size() ==rooms.size()){
            return  true;
        }
        return false;
    }

    private void recursiveVisited(List<Integer> visited, List<List<Integer>> rooms, int i){
        visited.add(i);
        List<Integer> list = rooms.get(i);

        for( int in :list){
            if(! visited.contains(i)){
                recursiveVisited(visited, rooms, in);
            }
        }
    }


}

