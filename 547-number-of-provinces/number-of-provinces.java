class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(isConnected, visited, i);
            }
        }
        return count;
    }

    private void dfs(int[][] graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int j = 0; j < graph.length; j++) {
            if (graph[node][j] == 1 && !visited[j]) {
                dfs(graph, visited, j);
            }
        }
    }
}