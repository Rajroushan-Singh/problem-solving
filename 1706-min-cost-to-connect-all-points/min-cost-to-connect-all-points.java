class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        List<List<int[]>> g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int wt=Math.abs(points[i][1]-points[j][1])+
                        Math.abs(points[i][0]-points[j][0]);
                        g.get(i).add(new int[]{j,wt});
                        g.get(j).add(new int[]{i,wt});

            }
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        boolean[] vis=new boolean[n];
        pq.offer(new int[]{0,0});
        int cost=0;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int node=curr[0];
            int wt=curr[1];
            if(vis[node])continue;
            vis[node]=true;
            cost+=wt;
            
            for(int[] nei:g.get(node)){
                int next=nei[0];
                int newwt=nei[1];
                if(!vis[next]){
                    pq.offer(new int[]{next,newwt});
                }
            }
        }
        return cost;
    }
}