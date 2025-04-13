package Matrix;

import java.util.Scanner;

public class RotateMatrixBy90Degree {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        rotateMatrix(matrix);
        System.out.println("After Rotation:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void rotateMatrix(int[][] matrix){
        //Transpose matrix
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //Reverse
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}
