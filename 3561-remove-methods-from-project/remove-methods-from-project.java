class Solution {
    public void dfs(int node,List<List<Integer>> g,boolean[] vis){
        vis[node]=true;
        for(int nei:g.get(node)){
            if(!vis[nei]){
                
                dfs(nei,g,vis);
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int[] a:invocations){
            int v=a[0];
            int u=a[1];
            g.get(v).add(u);
        }
        List<Integer> res=new ArrayList<>();

        boolean[] vis=new boolean[n];
        dfs(k,g,vis);
        for(int[] a:invocations){
            int v=a[0];int u=a[1];
            if(!vis[v] && vis[u]){
                List<Integer> arr=new ArrayList<>();
                for(int i=0;i<n;i++){
                    arr.add(i);
                }
                return arr;
            }
        }
        for(int i=0;i<n;i++){
            if(!vis[i]){
                res.add(i);
            }
        }
        return res;
    }
}