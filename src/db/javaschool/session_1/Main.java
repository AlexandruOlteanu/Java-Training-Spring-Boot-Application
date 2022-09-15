package db.javaschool.session_1;

import java.sql.SQLOutput;

public class Main {


    public static void main(String[] args) {
        int a = 3;
        a <<= 1;
        System.out.println(a);

        System.out.println("Hello world!");
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int [][] matrix2 = {
                {1,4,8},
                {2,6,3},
                {7,1,5}
        };
        System.out.println(sum(matrix, 3));
        Main.afisare(Main.sumOfTwo(matrix, matrix2, 3),3);
        afisare(multiplyMatrices(matrix, matrix2, 3 ), 3);

        System.gc();
    }

    public static int sum(int[][] matrix, int n) {
        int suma = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                suma += matrix[i][j];
            }
        }
        return suma;
    }

    public static int[][] sumOfTwo(int[][] matrix1, int[][] matrix2, int n) {
        int[][] suma = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                suma[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return suma;
    }

    public static void afisare(int[][] matrix, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2, int n) {
        int[][] result = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;

    }


}
