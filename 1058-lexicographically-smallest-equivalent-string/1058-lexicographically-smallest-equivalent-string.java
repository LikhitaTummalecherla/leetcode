class Solution {
    int[] parent = new int[26];

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Initialize each character as its own parent
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Union the characters from s1 and s2
        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        // Build the smallest equivalent string for baseStr
        StringBuilder result = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            int root = find(ch - 'a');
            result.append((char)(root + 'a'));
        }

        return result.toString();
    }

    // Find function with path compression
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union function to always keep lex smaller as root
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;
        if (px < py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
    }
}