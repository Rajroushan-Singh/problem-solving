class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> l=new ArrayList<>();
        solve(candidates,target,l,new ArrayList<>(),0);
        return l;
    }
    public void solve(int[] candidates,int target,List<List<Integer>> l,List<Integer> temp,int start ){
        // l.add(temp);
        // int sum=0;
        if(target==0){
            l.add
            (new ArrayList<>(temp));
            return ;
        }
        if(target<0){
            return ;
        }
        for(int i=start;i<candidates.length;i++){
            // take
                temp.add(candidates[i]);
                solve(candidates,target-candidates[i],l,temp,i);
                // 
                temp.remove(temp.size()-1);
                
            
        }
    }

}