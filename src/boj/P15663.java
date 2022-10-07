package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15663 {
    private static final StringBuilder sb = new StringBuilder();
    private static int n, m;
    private static int numbers[];
    private static int answer[];
    private static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        answer = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        find(0);

        System.out.println(sb);
    }

    private static void find(int depth) {
        if (depth == m) {
            for (int num : answer) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for(int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (before == numbers[i]) continue;
            visited[i] = true;
            answer[depth] = numbers[i];
            before = numbers[i];
            find(depth + 1);
            visited[i] = false;
        }
    }

}
