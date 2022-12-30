package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P09633 {
    private static int n, count;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        count = 0;
        answer = new int[n];

        find(0);

        System.out.println(count);
    }

    public static void find(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int value = 0; value < n; value++) {
            if (check(depth, value)) {
                answer[depth] = value;
                find(depth + 1);
            }
        }
    }

    public static boolean check(int depth, int value) {
        for (int row = 0; row < depth; row++) {
            if (value == answer[row]) return false;
            if (Math.abs(depth - row) == Math.abs(value - answer[row])) return false;
        }
        return true;
    }
}
