class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
            helper(candidates,ans,target,0,new ArrayList<>());
            return ans;
    }
    public void helper(int[] candidates,List<List<Integer>> ans, int target,int start,List<Integer> l){
        // List<Integer> l=new ArrayList<>();
        if(target==0){
            ans.add(new ArrayList<>(l));
        }
        for(int i=start;i<candidates.length;i++){
            if(target<candidates[i]){break;}
            if(i>start && candidates[i]==candidates[i-1]){continue;}
            l.add(candidates[i]);
            helper(candidates,ans,target-candidates[i],i+1, l);
            l.remove(l.size()-1);
        }
    }
}