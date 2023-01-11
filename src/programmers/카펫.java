package programmers;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int count = brown + yellow;

        for (int i = 1; i <= count; i++) {
            int width = i;
            int height = count / i;

            if (width < height) continue;
            if (width < 3 || height < 3) continue;
            if ((width - 2) * (height - 2) == yellow) {
                answer[0] = width;
                answer[1] = height;
            }
        }

        return answer;
    }
}
