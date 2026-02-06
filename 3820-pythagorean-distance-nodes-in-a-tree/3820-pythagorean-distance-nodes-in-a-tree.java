class Solution {
    public static int[] bfs(int x, ArrayList<Integer>[] adj, int n){
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[x] = 0;
        q.add(x);
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : adj[u]){
                if(dist[v] == -1){
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
        return dist;
    }
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        int[] d1 = bfs(x, adj, n);
        int[] d2 = bfs(y, adj, n);
        int[] d3 = bfs(z, adj, n);
        int ct = 0;
        for(int i = 0; i < n; i++){
            if(d1[i] == -1 || d2[i] == -1 || d3[i] == -1) continue; 
            int[] dist = {d1[i], d2[i], d3[i]};
            Arrays.sort(dist);
            if((dist[0] * dist[0]) + (dist[1] * dist[1]) == (dist[2] * dist[2])){
                ct++;
            }
        }
        return ct;
    }
}