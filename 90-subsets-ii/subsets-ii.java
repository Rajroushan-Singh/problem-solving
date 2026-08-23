class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Set<List<Integer> > set=new HashSet<>();
        Arrays.sort(nums);
        helper(ans,nums,set,new ArrayList<>(),0);
        return ans;
    }
    public void helper(List<List<Integer>> ans,int[] nums, Set<List<Integer> > set,List<Integer> l, int start){
            ans.add(new ArrayList<>(l));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            l.add(nums[i]);
            helper(ans,nums,set,l,i+1);
            l.remove(l.size()-1);

        }
    }
}