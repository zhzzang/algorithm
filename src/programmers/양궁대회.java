package programmers;

import java.util.Arrays;

class 양궁대회 {
    private int count;
    private int[] apeach;
    private int[] ryan = new int[11];
    private int apeachScore;
    private int ryanScore;
    private int[] answer = new int[11];
    private int maxDiff = 0;

    public int[] solution(int n, int[] info) {
        count = n;
        apeach = info;

        find(0, 0);

        if (Arrays.stream(answer).sum() == 0) {
            return new int[]{-1};
        }
        return answer;
    }

    private void find(int depth, int sum) {
        if (depth == 11) {
            update();
            return;
        }

        for (int i = 0; i <= count - sum; i++) {
            ryan[depth] = i;
            find(depth + 1, sum + i);
        }
    }

    private void update() {
        apeachScore = 0;
        ryanScore = 0;
        for (int i = 0; i < 11; i++) {
            if (apeach[i] == 0 && ryan[i] == 0) continue;
            if (apeach[i] >= ryan[i]) {
                apeachScore += 10 - i;
            } else {
                ryanScore += 10 - i;
            }
        }

        int diff = ryanScore - apeachScore;

        if (ryanScore <= apeachScore) return;

        if (diff > maxDiff) {
            maxDiff = diff;
            System.arraycopy(ryan, 0, answer, 0, 11);
            return;
        }

        if (diff == maxDiff) {
            for (int i = 10; i >= 0; i--) {
                if (ryan[i] > answer[i]) {
                    maxDiff = diff;
                    System.arraycopy(ryan, 0, answer, 0, 11);
                    return;
                } else if (answer[i] > ryan[i]) {
                    return;
                }
            }
        }
    }
}