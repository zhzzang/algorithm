package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P01182 {
    private static int n, s;
    private static int count = 0;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        numbers = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        find(0, 0);

        if (s == 0) count--;
        System.out.println(count);
    }

    private static void find(int depth, int sum) {
        if (depth == n) {
            if (sum == s) count++;
            return;
        }
        find(depth + 1, sum + numbers[depth]);
        find(depth + 1, sum);
    }
}
