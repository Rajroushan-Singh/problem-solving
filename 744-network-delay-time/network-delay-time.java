class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> g=new ArrayList<>();
        for(int i=0;i<=n;i++){
            g.add(new ArrayList<>());
        }
        for(int[] t:times){
            int u=t[0];
            int v=t[1];
            int wt=t[2];
            g.get(u).add(new int[]{v,wt});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] dis=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        pq.offer(new int[]{k,0});
        dis[k]=0;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int node=curr[0];
            int wt=curr[1];
            for(int[] nei:g.get(node)){
                int next=nei[0];
                int weight=nei[1];
                if(dis[node]+weight < dis[next]){
                    dis[next]=dis[node]+weight;
                    pq.offer(new int[]{next,dis[next]});
                }
                
            }
        }
        int d=0;
        for(int i=1;i<=n;i++){
            if(dis[i]==Integer.MAX_VALUE){
                return -1;
            }
            d=Math.max(d,dis[i]);
        }
        return d;
    }
}