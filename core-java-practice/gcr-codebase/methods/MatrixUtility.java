import java.util.Scanner;

public class MatrixUtility {

    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Generates random integers between 1 and 10
                matrix[i][j] = (int) (Math.random() * 10) + 1;
            }
        }
        return matrix;
    }

    public static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int r1 = A.length;
        int c1 = A[0].length;
        int c2 = B[0].length;
        int[][] result = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%4d ", element);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns for Matrix A: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        System.out.print("Enter rows and columns for Matrix B: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        int[][] A = createRandomMatrix(r1, c1);
        int[][] B = createRandomMatrix(r2, c2);

        System.out.println("\nMatrix A:");
        displayMatrix(A);
        System.out.println("\nMatrix B:");
        displayMatrix(B);

        // Addition and Subtraction logic
        if (r1 == r2 && c1 == c2) {
            System.out.println("\nAddition Result:");
            displayMatrix(addMatrices(A, B));

            System.out.println("\nSubtraction Result (A - B):");
            displayMatrix(subtractMatrices(A, B));
        } else {
            System.out.println("\nAddition/Subtraction not possible (Dimensions must match).");
        }

        // Multiplication logic
        if (c1 == r2) {
            System.out.println("\nMultiplication Result (AB):");
            displayMatrix(multiplyMatrices(A, B));
        } else {
            System.out.println("\nMultiplication not possible (Columns of A must match Rows of B).");
        }
        
        sc.close();
    }
}