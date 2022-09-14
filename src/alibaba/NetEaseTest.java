package alibaba;

import java.util.Scanner;

public class NetEaseTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int T = sc.nextInt();
            sc.nextLine();
            for (int it = 0; it < T; it++) {
                // List<StringBuilder> listInitial=new ArrayList<StringBuilder>();
                int[][] matrix = new int[3][3];


                for (int j = 0; j < 3; j++) {
                    String s = sc.nextLine();
                    char[] charArray = s.toCharArray();
                    for (int i = 0; i < 3; i++) {
                        char ch = charArray[0];
                        if (ch != '*')
                            matrix[j][i] = charArray[i] - '0';
                        else matrix[j][i] = 0;
                    }
                }//建立基本的矩阵
            }
        }
    }
}
