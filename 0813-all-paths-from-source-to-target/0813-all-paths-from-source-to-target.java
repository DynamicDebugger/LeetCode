class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n; i++) adj.add(new ArrayList<>());   
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < graph[i].length ; j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        boolean[] vis = new boolean[n];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        ds.add(0);
        dfs(0, n - 1, vis, adj, res, ds);
        return res;
    }

    private void dfs(int node, int n, boolean[] vis, List<List<Integer>> adj, List<List<Integer>> res, List<Integer> ds){
        if(node == n){
            res.add(new ArrayList<>(ds));
            return;
        }
        vis[node] = true;
        for(int neighbour: adj.get(node)){
            if(!vis[neighbour]){
                ds.add(neighbour);
                dfs(neighbour, n, vis, adj, res, ds);
                ds.remove(ds.size() - 1);
            }
        }
        vis[node] = false;
    }
}