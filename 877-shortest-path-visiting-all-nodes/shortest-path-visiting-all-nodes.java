class Solution {
    public int shortestPathLength(int[][] graph) {
        int n=graph.length;
        boolean[][] vis=new boolean[n][1<<n];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            int mask=1<<i;
            q.add(new int[]{i,mask,0});
            vis[i][mask]=true;
        }
        int allvis=(1<<n)-1;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int node=curr[0];
            int mask=curr[1];
            int dis=curr[2];
            if(mask==allvis){
                return dis;
            }
            for(int next:graph[node]){
                int newmask=mask|(1<<next);
                if(!vis[next][newmask]){
                    vis[next][newmask]=true;
                    q.add(new int[]{next,newmask,dis+1});
                }
            }
        }
        return -1;
    }
}