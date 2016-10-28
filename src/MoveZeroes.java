import java.util.Arrays;

/**
 * Created by prasanthnair on 10/26/16.
 */
public class MoveZeroes extends ASolution {
    @Override
    void runSolution() {
        int[] arr = new int[]{0,1,0,3,12};
//        int[] arr = new int[]{-1, 0, 1, 1, -2, 5};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && i < nums.length - 1) {
                int j = i + 1;
                for (; nums[j] == 0 && j < nums.length; j++){
                    if (j == nums.length - 1 && nums[j] == 0){
                        return;
                    }
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}
