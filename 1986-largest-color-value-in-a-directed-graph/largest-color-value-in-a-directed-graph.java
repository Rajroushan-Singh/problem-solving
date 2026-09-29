class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n=colors.length();
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        int[] in=new int[n];
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            in[v]++;
            g.get(u).add(v);
        }
        int[][] dp=new int[n][26];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(in[i]==0){
                q.offer(i);
            }
        }
        int c=0;
        int ans=0;
        while(!q.isEmpty()){
            int node=q.poll();
            c++;
            dp[node][colors.charAt(node)-'a']++;
            ans=Math.max(ans,dp[node][colors.charAt(node)-'a']);
            for(int nei:g.get(node)){
                
                for(int i=0;i<26;i++){
                    dp[nei][i]=Math.max(dp[nei][i],dp[node][i]);
                }
                in[nei]--;
                if(in[nei] == 0 ){
                    q.offer(nei);
                }

            }
            
        }if(c!=n)return -1;
        return ans;
    }
}