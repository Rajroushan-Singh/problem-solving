class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        // int[] pref=new int[n];
        // pref[0]=nums[0];
        // for(int i=1;i<n;i++){
        //     pref[i]=pref[i-1]+nums[i];
        // }
        int sum=0;int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            ans+=map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        // for(int i=0;i<n;i++){
        //     
        // }
        return ans;
         
    }
}