

class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int ans : answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }

        int total = 0;
        
        for (int k : map.keySet()) {
            int count = map.get(k);
            int groupSize = k + 1;
            int groups = (int) Math.ceil((double) count / groupSize);
            total += groups * groupSize;
        }

        return total;
    }
}