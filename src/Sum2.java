import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by prasanthnair on 10/24/16.
 */
/*
https://leetcode.com/problems/two-sum/

1. Two Sum   QuestionEditorial Solution  My Submissions

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

public class Sum2 extends ASolution {
    @Override
    void runSolution() {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{-1, 0, 1, 1, -2, 5}, 2)));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(indexMap.containsKey(target - nums[i])){
                return new int[]{i, indexMap.get(target - nums[i])};
            }
            indexMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
