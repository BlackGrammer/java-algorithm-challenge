package org.blackgrammer.etc;


public class SnakeSquare {

    public static void main(String[] args) {
        printSnakeSquare(1);
        printSnakeSquare(2);
        printSnakeSquare(3);
        printSnakeSquare(4);
        printSnakeSquare(5);
    }

    private static void printSnakeSquare(int size) {
        int[][] square = new int[size][size];
        int w = 0;
        int h = 0;
        int mode = 0;
        int loop = 0;
        for (int i = 1, len = size * size; i <= len; i++) {
            square[h][w] = i;
            switch (mode % 4) {
                case 0:
                    if (++w == size - loop - 1) mode++;
                    break;
                case 1:
                    if (++h == size - loop - 1) mode++;
                    break;
                case 2:
                    if (--w == loop) mode++;
                    break;
                case 3:
                    if (--h == loop + 1) {
                        mode++;
                        loop++;
                    }
                    break;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int i2 = 0; i2 < size; i2++) {
                System.out.print(square[i][i2] + " ");
            }
            System.out.println();
        }
    }
}
