class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int[] f:flights){
            int u=f[0];
            int v=f[1];
            int w=f[2];
            g.get(u).add(new int[]{v,w});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[][] dp=new int[n][k+2];
        // for(int i=0;i<=n;i++){
        //     dp[i][0]=0;
        // }
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[src][0]=0;
        pq.offer(new int[]{src,0,0});
        int stops=0;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int node=curr[0];
            int cost=curr[1];
            int stop=curr[2];
            if(node==dst)return cost;
            if(stop==k+1){continue;}
            
            for(int[] nei:g.get(node)){
                int next=nei[0];
                int totalcost=cost+nei[1];
                if(totalcost<dp[next][stop+1]){
                    dp[next][stop+1]=Math.min(dp[next][stop+1],totalcost);
                    pq.offer(new int[]{next,totalcost,stop+1});
                    
                }

            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<=k+1;i++){
            ans=Math.min(ans,dp[dst][i]);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}