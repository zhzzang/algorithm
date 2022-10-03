package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15652 {
    private static final StringBuilder sb = new StringBuilder();
    private static int n, m;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        find(0, 1);

        System.out.println(sb);
    }

    private static void find(int depth, int before) {
        if (depth == m) {
            for (int number : arr) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = before; i <= n; i++) {
            arr[depth] = i;
            find(depth + 1, i);
        }
    }
}
