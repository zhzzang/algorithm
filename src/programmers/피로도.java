package programmers;

class Solution {
    private static int answer;
    private static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];

        find(0, k, dungeons);

        return answer;
    }

    private void find(int depth, int k, int[][] dungeons) {
        answer = Math.max(answer, depth);

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            if (k < dungeons[i][0]) continue;
            visited[i] = true;
            find(depth + 1, k - dungeons[i][1], dungeons);
            visited[i] = false;
        }
    }
}
