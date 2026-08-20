class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        List<Integer> arr1=new ArrayList<>() ;
        List<Integer> arr2=new ArrayList<>();
        arr1.add(nums[0]);arr2.add(nums[1]);
        for(int i=2;i<n;i++){
            
            if(arr1.get(arr1.size()-1) > arr2.get(arr2.size()-1)){
                arr1.add(nums[i]);
            }else{
                arr2.add(nums[i]);
            }
        }
        // if(arr1.get(arr1.size()-1)>arr2.get(arr2.size()-1)){
            // arr1.add(nums[n-1]);
        // }else{
            // arr2.add(nums[n-1]);
        // }
        int[] main=new int[n];int idx=0;
        for(int num:arr1){
            main[idx++]=num;
        }        
        for(int num:arr2){
            main[idx++]=num;
        }

        return main;
    }
}