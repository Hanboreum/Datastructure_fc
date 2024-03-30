package javadatastructure.datastructure.twosum;

import java.util.ArrayList;
import java.util.List;

public class TwoSumRecursive {
    public static void main(String[] args) {
        int[] nums = {1, 2,1, 2, 5, 3, 6};
        int target = 4;
        SolutionRecursive solutionRecursive = new SolutionRecursive();
        solutionRecursive.twoSum(nums, target);
    }
}

class SolutionRecursive{
    public int[]twoSum ( int[]nums, int target){
        return backtracking (nums, target, 0, new ArrayList<Integer>());
    }

  private int[]backtracking(int[] nums, int target, int start, List<Integer>ans){
        if(ans.size() ==2){
            if(nums[ans.get(0)] + nums[ans.get(1)] == target){
                return new int[]{ans.get(0), ans.get(1)};
            }
            return null;
        }
        for( int i=start; i< nums.length; i++){
            ans.add(i);
            int[] result = backtracking(nums, target, i+1, ans);
            if(result != null){
                return result;
            }
            ans.remove(ans.size() - 1);
        }
      return null;
  }
}

/*
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        return backtracking(nums, target, 0, new ArrayList<Integer>());
    }

    private int[] backtracking(int[] nums, int target, int start, List<Integer> ans) {
        //✅ ans에 2개의 원소만 포함되어있다면 (base case)
        if (ans.size() == 2) {
            //✅ 두 정수의 합이 target과 같다면, ans를 반환한다.
            if (nums[ans.get(0)] + nums[ans.get(1)] == target) {
                return new int[]{ans.get(0), ans.get(1)};
            }
            //✅ 아니라면, null을 반환한다.
            return null;
        }
        //✅ start부터 마지막 원소 인덱스까지 순회한다.
        for (int i = start; i < nums.length; i++) {
            //✅ ans에 인덱스 i를 추가한다.
            ans.add(i);
            //✅ 재귀 함수를 호출한다.
            int[] result = backtracking(nums, target, i + 1, ans);
            //✅ 반환값이 존재하면, 반환값을 반환한다.
            if (result != null) {
                return result;
            }
            //✅ False가 반환되면, 인덱스 i를 ans에서 제거한다.
            ans.remove(ans.size() - 1);
        }
        return null;
    }
}


 */