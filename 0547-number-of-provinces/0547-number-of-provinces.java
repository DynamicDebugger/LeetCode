class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        int n = isConnected.length;
        for(int i = 0 ; i < n ; i++){
            ls.add(new ArrayList<>());
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(isConnected[i][j] == 1){
                    ls.get(i).add(j);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int c = 0;
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                c++;
                dfs(i, vis, ls);
            }
        }
        return c;
    }

    private void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> list){
        visited[node] = true;
        for(int it: list.get(node)){
            if(!visited[it]){
                dfs(it, visited, list);
            }
        }
    }    

}