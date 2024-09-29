class Solution {
    int maxCylce = -1;
    public int longestCycle(int[] edges) {
        int n = edges.length;

        boolean[] vis = new boolean[n];
        int[] dis = new int[n];

        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                dfs(i, vis, dis, edges, 0);
            }
        }

        return maxCylce;
    }

    private void dfs(int node, boolean[] vis, int[] dis, int[] edges, int curDis){
        vis[node] = true;
        dis[node] = curDis;
        int neighbour = edges[node];
 
        if(neighbour != - 1){           
            if(!vis[neighbour]){ 
                dfs(neighbour, vis, dis, edges, curDis + 1);
            }else if(dis[neighbour] != - 1){
                maxCylce = Math.max(maxCylce, curDis - dis[neighbour] + 1);
            }
            
        }
        dis[node] = -1;
    }
}