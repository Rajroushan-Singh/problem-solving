class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if(nums.length<2) return false;
        // int[] pref=new int[n];
        // pref[0]=nums[0];

        // for(int i=1;i<n;i++){
        //     pref[i]=pref[i-1]+nums[i];
        // }
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        map.put(0,-1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int rem=sum%k;
            if(map.containsKey(rem)){
                if(i-map.get(rem)>=2){
                    return true;
                }
                
            }else{
                map.put(rem,i);
            }
            
            
        }
        

        return false;
    }
}