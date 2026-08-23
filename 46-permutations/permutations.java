class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(nums,ans,new boolean[nums.length],new ArrayList<>());
        return ans;
    }
    public void helper(int[] nums , List<List<Integer>> ans , boolean[] used ,List<Integer> l){
        if (l.size() == nums.length){
            ans.add(new ArrayList<>(l));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            used[i]=true;

            l.add(nums[i]);
            helper(nums,ans,used,l);

            l.remove(l.size()-1);
            used[i]=false;
        }
    }
}