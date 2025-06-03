import java.util.*;

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> opened = new HashSet<>();
        boolean[] hasKey = new boolean[status.length];
        boolean[] available = new boolean[status.length];

        // Mark initial boxes as available and open those that are already unlocked
        for (int box : initialBoxes) {
            available[box] = true;
            if (status[box] == 1) {
                queue.offer(box);
                opened.add(box);
            }
        }

        int totalCandies = 0;

        while (!queue.isEmpty()) {
            int box = queue.poll();
            totalCandies += candies[box];

            // Collect keys and try to open new boxes with them
            for (int key : keys[box]) {
                hasKey[key] = true;
                if (available[key] && !opened.contains(key)) {
                    queue.offer(key);
                    opened.add(key);
                }
            }

            // Collect new boxes and open them if possible
            for (int contained : containedBoxes[box]) {
                available[contained] = true;
                if ((status[contained] == 1 || hasKey[contained]) && !opened.contains(contained)) {
                    queue.offer(contained);
                    opened.add(contained);
                }
            }
        }

        return totalCandies;
    }
}