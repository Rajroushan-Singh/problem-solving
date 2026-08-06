class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            g.add(new ArrayList<>());
        }
        int[] indegree=new int[numCourses];
        for(int[] p:prerequisites){
            int u=p[1];
            int v=p[0];
            g.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] toposort=new int[numCourses];
        int k=0;
        int count=0;
        while(!q.isEmpty()){
            int node=q.poll();
            count++;
            toposort[k++]=node;
            for(int nei:g.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }

        // return count==numCourses ? return : new ArrayList<>();
        if(count!=numCourses){
            return new int[]{};
        }
        return toposort;
    }
}