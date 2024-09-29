class Pair{
    int node;int weight;
    Pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());  

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];

            adj.get(u).add(new Pair(v, w));
        }      
        return dijsktra(adj, n, k);
    }

    private int dijsktra(List<List<Pair>> adj, int n, int k){
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        
        pq.add(new Pair(k,0));
        dis[k] = 0;

        while(!pq.isEmpty()){
            Pair node = pq.poll();
            int u = node.node;

            for(Pair it: adj.get(u)){
                int v = it.node;
                int w = it.weight;

                if(dis[u] + w < dis[v]){
                    dis[v] = dis[u] + w;
                    pq.add(new Pair(v, dis[v]));
                }
            }
        }

        int max = 0;
        for(int i = 1 ; i <= n ; i++){
            if(dis[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dis[i]);
        }

        return max;
    }
}