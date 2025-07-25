import java.util.*;

class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxDiff = Integer.MIN_VALUE;
        boolean found = false;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                for (int j = 0; j < 26; j++) {
                    if (freq[j] != 0 && freq[j] % 2 == 0) {
                        int diff = freq[i] - freq[j];
                        maxDiff = Math.max(maxDiff, diff);
                        found = true;
                    }
                }
            }
        }

        return found ? maxDiff : 0;
    }
}