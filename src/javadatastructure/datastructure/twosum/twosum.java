package javadatastructure.datastructure.twosum;

public class twosum {
   //target에게 인덱스 값을 리턴해야함.
    //정확히 하나의 솔루션만 있다는걸 보증.
    //같은 원소는 두 번 못쓴다.
    //인덱스의 순서는 상관 없.
    //하나씩 더해보기
    //if target 10, nums= [1,2,3,4,5,6,7] -> 이걸 완전 탐색이라고
    // 정답이 될 가능성이 있는 것을 모두 탐색
   public static void main(String[] args) {

       int[] nums = {1,2,3,4,7,6,5,1};
       int target =4;
       Solution solution = new Solution();
       int[] result1 = solution.twoSum(nums,target);
       System.out.println(result1[0] +" "+ result1[1]);

       Solution2 solution2 = new Solution2();
       int[] result2 = solution2.threeSum(nums, target);
       System.out.println(result2[1] + " "+ result2[1] + " "+ result2[2]);

   }

}
//반복문
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for( int i=0; i< nums.length; i++){
            for( int j= i+1; j<=nums.length; j++){
                if(nums[i]+ nums[j]== target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[] {-1,-1}; //return null;
        //조건문이 만족하지 않았을 때 리턴? 인트형 배열로 돌려줘야되고..뭐라냐
    }
}

class Solution2{
    public int[] threeSum(int[] nums, int target){
        for( int i=0; i< nums.length; i++){
            for(int j= i+1; j< nums.length; j++){
                for(int k= j+1; k < nums.length; k++){
                    if(nums[i] + nums[j]+ nums[k] == target){
                        return new int[]{i,j,k};
                    }
                }
            }
        }
        return null;
    }
}

