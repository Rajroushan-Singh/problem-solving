class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==1)return true;
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            g.add(new ArrayList<>());
        }
        int[] indegree=new int[numCourses];
        Queue<Integer> q=new LinkedList<>();
        for(int[] p:prerequisites){
            int v=p[0];
            int u=p[1];
            g.get(u).add(v);
            // g.get
            indegree[v]++;
        }
        
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int c=0;
        while(!q.isEmpty()){
            int node=q.poll();
            c++;
            for(int nei:g.get(node)){
                indegree[nei]--;  
                if(indegree[nei]==0){
                    q.add(nei);
                } 
            }
            // if(c!=numCourses){
            //     return true;
            // }
        }
        return c==numCourses;

    }
}