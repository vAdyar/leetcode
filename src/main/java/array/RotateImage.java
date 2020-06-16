package array;

import utils.ArrayUtils;

public class RotateImage {

    public static void rotate90anticlock(int[][] a) {
        int n = a.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1 ; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][n-1-i];
                a[j][n-1-i] = a[n-1-i][n-1-j];
                a[n-1-i][n-1-j] = a[n-1-j][i];
                a[n-1-j][i] = temp;
            }
        }
    }

    public static void rotate90clock(int[][] a) {
        int n = a.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1 ; j++) {
                int temp = a[i][j];
                a[i][j] = a[n-1-j][i];
                a[n-1-j][i] = a[n-1-i][n-1-j];
                a[n-1-i][n-1-j] = a[j][n-1-i];
                a[j][n-1-i] = temp;
            }
        }
    }

    public static void main(String[] args) {
//        int [][] image = {
//                { 5, 1, 9,11},
//                { 2, 4, 8,10},
//                {13, 3, 6, 7},
//                {15,14,12,16}
//        };

        int[][] image = {{1,2,3},{4,5,6},{7,8,9}};

//        rotate90anticlock(image);
        rotate90clock(image);
        ArrayUtils.print(image);
    }
}
