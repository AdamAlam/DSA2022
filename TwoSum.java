import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/two-sum/

class TwoSum {
    public static void main(String[] args) {
        int[] testArr = {2,3,4};
        int[] result = optimized(testArr, 6);
        System.out.println(Arrays.toString(result));
    }

    public static int[] brute(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j< nums.length; j++ ) {
                int num1 = nums[i];
                int num2 = nums[j];
                if (num1 + num2 == target) {
                    return new int[] {num1, num2};
                }
            }
        }
        return new int[] {-1, -1};

    }


    public static int[] optimized(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            int complement = target - curNum;
            if (!hm.containsKey(curNum)) {
                hm.put(complement, i);
            } else {
                return new int[] {hm.get(curNum), i};
            }

        }
        return new int[] {-1, -1};
    }
}