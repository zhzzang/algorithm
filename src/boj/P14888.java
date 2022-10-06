package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14888 {
    private static int n;
    private static int[] numbers;
    private static int[] operators = new int[4];
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        find(0, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void find(int depth, int value) {
        if (depth == n - 1) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] == 0) continue;
            operators[i]--;
            find(depth + 1, calculate(i, value, numbers[depth + 1]));
            operators[i]++;
        }
    }

    private static int calculate(int operator, int first, int second) {
        if (operator == 0) {
            return first + second;
        }
        if (operator == 1) {
            return first - second;
        }
        if (operator == 2) {
            return first * second;
        }
        if (operator == 3) {
            return first / second;
        }
        return 0;
    }
}
