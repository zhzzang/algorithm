package programmers;

class Solution {

    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int i = 0; i < sizes.length; i++) {
            int large = Math.max(sizes[i][0], sizes[i][1]);
            maxWidth = Math.max(maxWidth, large);
            int small = Math.min(sizes[i][0], sizes[i][1]);
            maxHeight = Math.max(maxHeight, small);
        }

        return maxWidth * maxHeight;
    }
}
