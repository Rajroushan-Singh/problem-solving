class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max_sum=nums[0];
        int min_sum=nums[0];
        int n=nums.length;
        int total_sum=nums[0];
        int max=nums[0];
        int min=nums[0];
        for(int i=1;i<n;i++){
            total_sum+=nums[i];
            max=Math.max(nums[i],max+nums[i]);
            min=Math.min(nums[i],min+nums[i]);
            max_sum=Math.max(max_sum,max);
            min_sum=Math.min(min_sum,min);
        }
        if (max_sum < 0) return max_sum;
        return Math.max(max_sum,total_sum-min_sum);
    }
}