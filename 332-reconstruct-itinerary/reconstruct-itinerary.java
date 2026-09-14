class Solution {        
    List<String> ans=new ArrayList<>();
    Queue<String> q=new LinkedList<>();
    Map<String, PriorityQueue<String> > map=new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for(List<String> l:tickets){
            String from=l.get(0);
            String to=l.get(1);
            map.putIfAbsent(from, new PriorityQueue<>());
            map.get(from).offer(to);

        }
        int n=map.size();
        q.offer("JFK");
        dfs("JFK");
        // while(!q.isEmpty()){
        //     String node=q.poll();
        //     ans.add(node);
        //     for(String nei:map.get(node)){
        //         dfs(nei);
        //     }
        // }
        Collections.reverse(ans);
        return ans;
    }
    public void dfs(String node){
        while(map.containsKey(node) && !map.get(node).isEmpty() ){
            String next=map.get(node).poll();
            dfs(next);
        }
        ans.add(node);
    }
}