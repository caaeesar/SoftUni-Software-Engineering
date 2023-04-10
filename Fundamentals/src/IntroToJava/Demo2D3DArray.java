package IntroToJava;

import java.util.Arrays;

public class Demo2D3DArray {
    public static void main(String[] arguments) {
/*
        int[][] array = {
                {1, 2, 3,},
                {5, 6, 7, 8},
                {1},
                {5,6,7}
        };

 */
       /* int[][][] array = {     // 3D array with size 3 x 3 x 3
                {
                        {10, 20, 30},
                        {40, 50, 60},
                        {70, 80, 90}
                },
                {
                        {20, 50, 60},
                        {66, 77, 86},
                        {45, 35, 76}
                },
                {
                        {13, 24, 35},
                        {45, 55, 65},
                        {75, 85, 95}
                }
        };
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {

                System.out.print(Arrays.toString(array[i][j]));
            }
            System.out.println();
        }*/

        int[][][] array3D = {
                {
                        {10, 20, 30},
                        {40, 50, 60},
                        {70, 80, 90}
                },
                {
                        {10, 20, 30},
                        {40, 50, 60},
                        {70, 80, 90}
                },
        };

        for (int i = 0; i < array3D.length; i++) {

            for (int j = 0; j < array3D[i].length; j++) {

                System.out.print(Arrays.toString(array3D[i][j]));
            }
            System.out.println();

        }
    }
}
