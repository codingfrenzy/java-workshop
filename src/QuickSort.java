import java.util.Arrays;

/**
 * Created by prasanthnair on 10/1/15.
 */
public class QuickSort {
    static int[] array = {736, 847, 375, 29, 110, 188, 362, 201, 925, 224, 93, 779, 138, 478, 767, 981, 776, 729, 197, 221, 883, 678, 650, 399, 949, 375, 261, 968, 219, 866, 924, 483, 479, 664, 650, 3, 416, 711, 492, 137, 146, 575, 642, 531, 592, 449, 288, 384, 433, 335, 337, 499, 551, 3, 84, 967, 202, 250, 819, 688, 780, 215, 453, 699, 929, 269, 356, 322, 900, 725, 721, 973, 293, 278, 866, 248, 294, 252, 835, 675, 733, 8, 121, 337, 95, 554, 341, 277, 157, 171, 299, 402, 380, 132, 954, 86, 546, 11, 518, 915};

    static int getPivot(int min, int max) {
        return (max + min) / 2;
    }

    static void quickSort(int min, int max) {
        if ((max - min) == 1)
            return;
    }

    public static void main(String[] args) {
        quickSort(0, array.length - 1);
        System.out.print(Arrays.toString(array));
    }
}