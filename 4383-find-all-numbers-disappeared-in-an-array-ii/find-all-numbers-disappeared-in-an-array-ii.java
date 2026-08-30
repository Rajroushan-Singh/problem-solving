class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> ans=new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i:nums)set.add(i);            
        List<Integer> l=new ArrayList<>();

        for(int i=lower;i<=upper;i++){
            if(!set.contains(i)){
                l.add(i);
            }
            else{
                if(!l.isEmpty()){
                    ans.add(l);
                    l=new ArrayList<>();
                
                }
            }
        } 
        if(!l.isEmpty()){
            ans.add(l);
        }
        for(List<Integer> t:ans){
            if(t.size()==1){
                int temp=t.get(0);
                t.add(temp);
            }
            if(t.size()>2){
                int a=t.get(0);
                int z=t.get(t.size()-1);
                t.clear();
                t.add(a);
                t.add(z);
            }
        }
        return ans;
    }
}