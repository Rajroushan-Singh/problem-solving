class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        // int[] pref=new int[n];
        // pref[0]=nums[0];
        // for(int i=1;i<n;i++){
        //     pref[i]=pref[i-1]+nums[i];
        // }
        Map<Integer,Integer> map=new HashMap<>();
        int ans=0;
        int sum=0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int rem=sum%k;
            if(rem<0){
                rem+=k;
            }

            ans+=map.getOrDefault(rem,0);
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return ans;
    }
}