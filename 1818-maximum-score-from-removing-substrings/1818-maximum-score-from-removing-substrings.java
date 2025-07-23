class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return removePattern(s, 'a', 'b', x, y);
        } else {
            return removePattern(s, 'b', 'a', y, x);
        }
    }

    private int removePattern(String s, char first, char second, int firstVal, int secondVal) {
        StringBuilder remaining = new StringBuilder();
        int score = 0;

        // First pass: remove first pattern
        for (char c : s.toCharArray()) {
            int len = remaining.length();
            if (len > 0 && remaining.charAt(len - 1) == first && c == second) {
                remaining.deleteCharAt(len - 1);
                score += firstVal;
            } else {
                remaining.append(c);
            }
        }

        // Second pass: remove second pattern
        StringBuilder finalPass = new StringBuilder();
        for (char c : remaining.toString().toCharArray()) {
            int len = finalPass.length();
            if (len > 0 && finalPass.charAt(len - 1) == second && c == first) {
                finalPass.deleteCharAt(len - 1);
                score += secondVal;
            } else {
                finalPass.append(c);
            }
        }

        return score;
    }
}