package programmers;

import java.util.HashSet;
import java.util.Set;

class Solution {
    private boolean[] visited;
    private String[] number;
    private int count = 0;
    private Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        number = numbers.split("");

        find(0, "");

        return set.size();
    }

    private void find(int depth, String temp) {
        if (!temp.equals("")) {
            int num = Integer.parseInt(temp);
            if (isPrime(num)) set.add(num);
        }

        if (depth == number.length) return;

        for (int i = 0; i < number.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            find(depth + 1, temp + number[i]);
            visited[i] = false;
        }
    }

    private boolean isPrime(int num) {
        if(num == 1 || num == 0) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}