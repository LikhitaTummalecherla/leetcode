class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
       int m=grid.length, n=grid[0].length;
       int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

       int k=queries.length;
       int[][] sortedQueries = new int[k][2];
       for (int i=0;i<k;i++){
        sortedQueries[i] = new int[]{queries[i], i};
       }
       Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));

       PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
       boolean[][] visited = new boolean[m][n];
       pq.offer(new int[]{grid[0][0],0,0});
       visited[0][0]=true;

       int[] answer = new int[k];
       int count=0;
       int queryIndex=0;

       while (queryIndex < k){
        int currentQuery = sortedQueries[queryIndex][0];

            while (!pq.isEmpty() && pq.peek()[0] < currentQuery) {
                int[] cell = pq.poll();
                int val = cell[0], r = cell[1], c = cell[2];
                count++;  
                for (int[] d : directions) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                        pq.offer(new int[]{grid[nr][nc], nr, nc});
                        visited[nr][nc] = true;

                    }
                }
            }
            answer[sortedQueries[queryIndex][1]] = count;
            queryIndex++;
       }
        return answer;
    }
}