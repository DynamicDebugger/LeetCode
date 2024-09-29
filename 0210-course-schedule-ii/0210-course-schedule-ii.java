class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses; i++) adj.add(new ArrayList<>());
        int[] inDeg = new int[numCourses];
        for(int[] edge: prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
            inDeg[u]++;
        }

        Queue<Integer> qu = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(inDeg[i] == 0){
                qu.add(i);
            }
        }

        // int[] ls = new int[numCourses];int i = 0;
        List<Integer> ls = new ArrayList<>();

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

        return ls.size() == numCourses?ls.stream().mapToInt(i -> i).toArray(): new int[0];
    }
}