class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < prerequisites.length; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(u).add(v);
        }
        //adj list is created apply topo sort
        return isCyclic(numCourses, adj);
    }
    public boolean isCyclic(int v, List<List<Integer>> adj) {
        //compute indegree
        int[] inDeg = new int[v];
        for(int i = 0 ; i < v ; i++){
            for(int it : adj.get(i)){
                inDeg[it]++;
            }
        }
        
        //add node with 0 indegree to queue
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 0 ; i < v ; i++){
            if(inDeg[i] == 0){
                qu.add(i);
            }
        }
        
        List<Integer> ls = new ArrayList<>();
        int i = 0;
        //remove the front and apply modified bfs
        
        while(!qu.isEmpty()){
            int node = qu.peek();
            qu.remove();
            
            ls.add(node);
            
            for(int it: adj.get(node)){
                inDeg[it]--;
                if(inDeg[it] == 0){
                    qu.add(it);
                }
            }
        }
        
        return ls.size() == v;
    }    
}