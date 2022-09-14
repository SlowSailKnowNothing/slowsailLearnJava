package meituan;

import java.util.LinkedList;
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

class MonotonicQueue {

    LinkedList<Integer> q = new LinkedList<>();

    public void push(int n) {

        // 将小于 n 的元素全部删除

        while (!q.isEmpty() && q.getLast() < n) {

            q.pollLast();

        }

        // 然后将 n 加入尾部

        q.addLast(n);

    }



    public int max() {

        return q.getFirst();

    }



    public void pop(int n) {

        if (n == q.getFirst()) {

            q.pollFirst();

        }

    }

}
