package alibaba;

import java.util.Scanner;

public class TestTemplate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int row = sc.nextInt();
            int col = sc.nextInt();

            int[][] input = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    input[i][j] = sc.nextInt();
                }
            }
            System.out.println();
        }
    }
}
