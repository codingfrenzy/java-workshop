import java.util.Arrays;

/**
 * Created by prasanthnair on 6/30/15.
 */
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int prev = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (prev != nums[i]) {
                prev = nums[i];
                count++;
            }
        }
        nums[1] = 4;
        return count;

    }

    public static void main(String[] args) {
        int[] a = {1,1,2};
        System.out.println(RemoveDuplicatesFromSortedArray.removeDuplicates(a));
        System.out.println(java.util.Arrays.toString(a));
    }
}
