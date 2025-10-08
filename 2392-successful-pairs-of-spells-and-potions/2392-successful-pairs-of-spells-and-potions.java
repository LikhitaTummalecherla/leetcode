class Solution {
    private int solve(int[] p, long tar){
        int m = p.length;
        int l = 0, r = m;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(p[mid] < tar){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return m - l;
    }

    public int[] successfulPairs(int[] s, int[] p, long sucs) {
        Arrays.sort(p);
        int n = s.length, m = p.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            long tar = sucs / s[i];
            tar += (sucs % s[i] == 0 ? 0 : 1);
            ans[i] = solve(p, tar);
        }
        return ans;
    }
}