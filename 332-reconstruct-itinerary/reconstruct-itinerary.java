class Solution {
    public void dfs(String s,Map<String,List<String>> g,List<String> ans){
        while(!g.get(s).isEmpty() ){
            String to=g.get(s).remove(g.get(s).size()-1);
            dfs(to,g,ans);
        }
        ans.add(s);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> g=new HashMap<>();
        for(List<String> l:tickets){
            String from=l.get(0);
            String to=l.get(1);
            g.putIfAbsent(from,new ArrayList<>());
            g.putIfAbsent(to,new ArrayList<>());
            g.get(from).add(to);
        }
        for (List<String> destinations : g.values()) {
            destinations.sort(Collections.reverseOrder());
        }

        List<String> ans=new ArrayList<>();
        dfs("JFK",g,ans);
        Collections.reverse(ans);
        return ans;

    }
}