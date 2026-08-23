class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer> > ans=new ArrayList<>();
        helper(ans, n , k , 1 , new ArrayList<>());
        return ans;
    }
    public void helper(List<List<Integer>> ans, int n, int k,  int start,List<Integer> l){
        if(l.size() == k){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=start;i<=n;i++){
            l.add(i);
            helper(ans,n,k,i+1,l);
            l.remove(l.size()-1);
        }
    }
}