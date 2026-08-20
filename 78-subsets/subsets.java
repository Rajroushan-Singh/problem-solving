class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> l=new ArrayList<>();
        helper(nums,l,new ArrayList<>(),0);
        return l;
    }
    public void helper(int[] nums,List<List<Integer>> l,List<Integer> temp,int start){
        // =new ArrayList<>();
        l.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            // l.add(new ArrayList<>(temp));
            helper(nums,l,temp,i+1);
            temp.remove(temp.size()-1);
            // l.add(new ArrayList<>(temp));
            
        }
        // temp.remove(nums[end]);
        
    }

}