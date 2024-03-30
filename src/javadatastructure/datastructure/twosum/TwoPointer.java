package javadatastructure.datastructure.twosum;

import java.awt.*;
import java.util.Arrays;

public class TwoPointer {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 5, 3, 6};
        int target = 4;
        PointerTwo pointerTwo = new PointerTwo();
        int[] result = pointerTwo.twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);

    }
}

    /* public int[] twoSum(int[] nums, int target) {
         //✅ 숫자와 숫자의 원래 인덱스를 저장하는 2차원 배열을 생성한다.
         int[][] arr = new int[nums.length][2];
         for (int i = 0; i < nums.length; i++) {
             arr[i][0] = nums[i];
             arr[i][1] = i;
         }
         //✅ 배열을 숫자의 오름차순으로 정렬한다.
         Arrays.sort(arr, (o1, o2) -> {
             return o1[0] - o2[0];
         });

         //✅ 첫 번째 인덱스와 마지막 인덱스를 각각 가리키는 두 포인터를 생성한다.
         int l = 0, r = nums.length - 1;
         //✅ 왼쪽 포인터가 오른쪽 포인터보다 작을 동안 반복한다.
         while (l < r) {
             //✅ 합이 target보다 크면 오른쪽 포인터를 왼쪽으로 한칸 옮긴다.
             if (arr[l][0] + arr[r][0] > target)
                 r -= 1;
                 //✅ 합이 target보다 작으면 왼쪽 포인터를 오른쪽으로 한칸 옮긴다.
             else if (arr[l][0] + arr[r][0] < target)
                 l += 1;
                 //✅ 만약 두 포인터가 가리키는 숫자의 합이 target과 같으면 결과 출력한다.
             else
                 return new int[]{ arr[l][1], arr[r][1] };
         }
         return new int[]{ -1, -1 };
     }
 }*/
    class PointerTwo {
        public int[] twoSum(int[] nums, int target) {
            int[][] arr = new int[nums.length][2];

            for (int i = 0; i < nums.length; i++) {
                arr[i][0] = nums[i];
                arr[i][1] = i;
            }
            Arrays.sort(arr, (o1, o2) -> {
                return o1[0] - o2[0];
            });
            int l = 0, r = nums.length - 1;
            while (l < r) {
                if (arr[l][0] + arr[r][0] > target)
                    r -= 1;
                else if (arr[l][0] + arr[r][0] < target)
                    l += 1;
                else
                    return new int[]{arr[l][1], arr[r][1]};
            }
            return new int[]{-1, 1};
        }
    }
