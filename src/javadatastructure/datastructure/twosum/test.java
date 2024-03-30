package javadatastructure.datastructure.twosum;

import java.sql.Array;
import java.util.*;

public class test {
    public static void main(String[] args) {
        int[] nums = {1, 2,1, 2, 5, 3, 6};
        int target = 4;
       int[] result = twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);

        int[] threeResultl = threeSum(nums, target);
        System.out.println(threeResultl[0] + " " + threeResultl[1] + " "+ threeResultl[2]);

        Recursive recursive = new Recursive();
        recursive.twoSum(nums,target);
       int[] recursiveResult = twoSum(nums, target);
        System.out.println(recursiveResult[0] + " " + recursiveResult[1]);

    }

    public static int[] twoSum(int[] nums, int target){
        for(int i=0; i< nums.length; i++){
            for( int j= i+1; j< nums.length; j++){
                if( nums[i] + nums[j] == target){
                    return new int[]{ i,j};
                }
            }
        }
       return null;
    }

    public static int[]threeSum(int[]nums, int target){
        for( int i=0; i< nums.length; i++){
            for(int j=i+1; j< nums.length; j++){
                for( int k=j+1; k< nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == target){
                        return new int[] { i,j,k};
                    }
                }
            }
        }
        return null;
    }


}

class Recursive{
    public int[] twoSum( int[] nums, int target){
        return backtracking(nums, target, 0, new ArrayList<Integer>());
    }
    private int[] backtracking(int[] nums, int target, int start, List<Integer> ans){
        if(ans.size() == 2){
            if(nums[ans.get(0)] + nums[ans.get(1)] == target){
                return new int [] {ans.get(0), ans.get(1)};
            }
            return null;
        }
        for( int i=start; i< nums.length; i++){
            ans. add(i);
            int[] result = backtracking(nums, target, i+1, ans);
            if( result != null){
                return result;
            }
            ans.remove(ans.size() -1);
        }
        return null;
    }
}

class rec {
   public int[] Two( int[]nums, int target){
       return back( nums, target,0, new ArrayList<Integer>());
   }
   public int[] back( int[] nums, int target, int start, List<Integer> ans){
       if( ans.size() == 2){
           if( nums[ ans.get(0)] + nums[ ans. get(1)] == target) {
               return new int[] { ans.get(1), ans.get(1)};
           }
           return null;
       }
      for( int i= start; i< nums.length; i++){
          ans.add(i);
          int[] result = back(nums,target, i+1, ans);

          if( result != null){
              return result;
          }
          ans.remove( ans.size() -1);
      }
      return null;
   }
}



