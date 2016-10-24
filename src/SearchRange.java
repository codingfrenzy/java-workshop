/**
 * Created by prasanthnair on 10/23/16.
 */
/*
https://leetcode.com/problems/search-for-a-range

34. Search for a Range   QuestionEditorial Solution  My Submissions

Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

 */
public class SearchRange extends ASolution {
    @Override
    void runSolution() {

    }

    public int[] searchRange(int[] nums, int target) {

        int leftStartRange = -1;
        int rightStartRange = -1;

        if (nums == null || nums.length == 0) {
            return new int[]{leftStartRange, rightStartRange};
        }

        int low = 0;
        int high = nums.length - 1;
        int mid = getMid(low, high);

        while (low <= high) {
            if (nums[mid] == target) {
                leftStartRange = mid;
                rightStartRange = mid;
                break;
            }

            if (nums[mid] < target) {
                low = mid + 1;
                mid = getMid(low, high);
            } else {
                high = mid - 1;
                mid = getMid(low, high);
            }
        }

        if (leftStartRange == -1 && rightStartRange == -1) {
            return new int[]{leftStartRange, rightStartRange};
        }

        // find left start
        if (leftStartRange != 0) {
            low = 0;
            high = leftStartRange - 1;
            mid = getMid(low, high);
            while (low <= high) {
                if (mid == 0 && nums[mid] == target) {
                    leftStartRange = 0;
                    break;
                }

                if (mid != 0 && nums[mid] == target && nums[mid - 1] != target) {
                    leftStartRange = mid;
                    break;
                }

                if (nums[mid] < target) {
                    low = mid + 1;
                    mid = getMid(low, high);
                } else {
                    high = mid - 1;
                    mid = getMid(low, high);
                }
            }
        }

        // find right start
        if (rightStartRange != nums.length - 1) {
            low = rightStartRange + 1;
            high = nums.length - 1;
            mid = getMid(low, high);
            while (low <= high) {
                if (mid == nums.length - 1 && nums[mid] == target) {
                    rightStartRange = nums.length - 1;
                    break;
                }

                if (nums[mid] == target && nums[mid + 1] != target) {
                    rightStartRange = mid;
                    break;
                }

                if (nums[mid] <= target) {
                    low = mid + 1;
                    mid = getMid(low, high);
                } else {
                    high = mid - 1;
                    mid = getMid(low, high);
                }
            }
        }

        return new int[]{leftStartRange, rightStartRange};
    }

    private int getMid(int low, int high) {
        return low + ((high - low) / 2);
    }
}

/*
Solution:


 */