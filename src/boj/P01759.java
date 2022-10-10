package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P01759 {
    private static final StringBuilder sb = new StringBuilder();
    private static int l, c;
    private static String[] alphabets;
    private static String[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        answer = new String[l];
        alphabets = new String[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            alphabets[i] = st.nextToken();
        }

        Arrays.sort(alphabets);

        find(0, 0);
        System.out.println(sb);

    }

    private static void find(int depth, int before) {
        if (depth == l) {
            if (isValid(answer)) {
                for (String alphabet : answer) {
                    sb.append(alphabet);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = before; i < c; i++) {
            answer[depth] = alphabets[i];
            find(depth + 1, i + 1);
        }
    }

    private static boolean isValid(String[] arr) {
        int vowel = 0;
        int consonant = 0;

        for (String s : arr) {
            if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) {
                vowel++;
            } else {
                consonant++;
            }
        }

        if ((vowel > 0) && (consonant > 1)) return true;

        return false;
    }
}
