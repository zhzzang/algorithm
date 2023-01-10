package programmers;

class Solution {

    public int solution(int[][] sizes) {
        int[] larger = new int[sizes.length];
        int[] smaller = new int[sizes.length];
        int maxWidth = 0;
        int maxHeight = 0;

        for (int i = 0; i < sizes.length; i++) {
            larger[i] = Math.max(sizes[i][0], sizes[i][1]);
            maxWidth = Math.max(maxWidth, larger[i]);
            smaller[i] = Math.min(sizes[i][0], sizes[i][1]);
            maxHeight = Math.max(maxHeight, smaller[i]);
        }

        return maxWidth * maxHeight;
    }
}
