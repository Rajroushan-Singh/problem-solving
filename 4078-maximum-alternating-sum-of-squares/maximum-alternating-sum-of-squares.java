class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                nums[i]= -nums[i];
            }
        }
        int n=nums.length;
        int odd=0;int even=0;
        if(n%2==0){
            even=n/2;
            odd=n/2;
        }else{
            even=n/2+1;
            odd=n/2;
        }
        int[] min=new int[odd];
        int[] max=new int[even];
        Arrays.sort(nums);
        int idx=0;
        for(int i=0;i<odd;i++){
            min[idx++]=nums[i];

        }
         idx=0;
        for(int i=odd;i<n;i++){
            max[idx++]=nums[i];
        }
        long sume=0;
        for(int i=0;i<even;i++){
            sume+=(long)(max[i]*max[i]);
        }
        long sumo=0;
        for(int i=0;i<odd;i++){
            sumo+=(long)(min[i]*min[i]);
        }
        return (long)(sume-sumo);
    }
}