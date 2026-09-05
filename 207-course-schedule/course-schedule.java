class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==1)return true;
        int n=prerequisites.length;
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            g.add(new ArrayList<>());
        }        
        int[] indegree=new int[numCourses];

        for(int[] pre:prerequisites){
            int u=pre[0];
            int v=pre[1];
            g.get(v).add(u);
            indegree[u]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int c=0;
        while(!q.isEmpty()){
            int node=q.poll();
            c++;
            for(int nei:g.get(node) ){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.add(nei);
                }
            } 
        }
        return c==numCourses;
    }
}