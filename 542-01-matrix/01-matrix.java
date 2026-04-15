class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(dist[i], -1);
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int r = cur[0] + d[0];
                int c = cur[1] + d[1];
                if (r >= 0 && c >= 0 && r < rows && c < cols && dist[r][c] == -1) {
                    dist[r][c] = dist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{r, c});
                }
            }
        }

        return dist;
    }
}