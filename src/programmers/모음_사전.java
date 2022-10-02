package programmers;

public class 모음_사전 {
    private static final String[] alphabets = {"A", "E", "I", "O", "U"};
    private int count = 0;
    private int answer = 0;

    public int solution(String word) {
        find("", word, 0);
        return answer;
    }

    private void find(String current, String target, int length) {
        if (length == 6) {
            return;
        }

        if (current.equals(target)) {
            answer = count;
            return;
        }
        count++;

        for (String alphabet : alphabets) {
            find(current + alphabet, target, length + 1);
        }
    }
}
