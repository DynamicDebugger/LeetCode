class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int dst = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.get(i).add(new Pair(j, dst));
                adj.get(j).add(new Pair(i, dst));
            }
        }
        return primsMST(adj, n);
    }

    private int primsMST(List<List<Pair>> adj, int n){

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);//d,s,p -> minheap based on index_0
        boolean[] vis = new boolean[n];

        pq.add(new int[]{0, 0, - 1});
        int sum = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int u = cur[1];
            if(vis[u]) continue;

            sum += cur[0];

            vis[u] = true;

            for(Pair pair : adj.get(u)){
                int v = pair.n, wt = pair.d;
                if(!vis[v]){
                    pq.add(new int[]{wt, v, u});
                }
            }
        }
        return sum;
    }
}
class Pair{
    int n, d;
    Pair(int n, int d){
        this.n = n;
        this.d = d;
    }
}