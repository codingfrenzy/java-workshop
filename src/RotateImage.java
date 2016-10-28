/**
 * Created by prasanthnair on 10/27/16.
 */
public class RotateImage extends ASolution {
    @Override
    void runSolution() {
        int[][] mat = new int[4][4];
        int k = 1;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = k++;
            }
        }
        rotate(mat);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();

        int[][] mat = new int[3][3];
        int k = 1;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = k++;
            }
        }
    }

    public void rotate(int[][] matrix) {
        printMatrix(matrix);
        int diagonalLimit;
        int n = matrix.length;
        if (n % 2 == 0) {
            diagonalLimit = (n - 1) / 2;
        } else {
            diagonalLimit = (n / 2) - 1;
        }
        System.out.println("Diag limit:" + diagonalLimit);

        for (int i = 0; i <= diagonalLimit; i++) {
            for (int k = i; k < n - i - 1; k++) {
                int row = i;
                int col = k;
                int temp = matrix[row][col];
                for (int j = 0; j < 4 /*n - (i * 2)*/; j++) {
                    int rowTemp = col;
                    int colTemp = n - 1 - row;
                    int temp2 = matrix[rowTemp][colTemp];
                    matrix[rowTemp][colTemp] = temp;
                    temp = temp2;
                    row = rowTemp;
                    col = colTemp;
                }
            }
        }
        printMatrix(matrix);
    }
}
