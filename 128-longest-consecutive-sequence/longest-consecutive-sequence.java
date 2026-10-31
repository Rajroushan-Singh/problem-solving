class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        // if(n==1)return 1;
        // Map<Integer,Integer> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        for(int i:nums)set.add(i);
        int len=0;
        for(int num:set){
            
            if(!set.contains(num-1) ){
                // int curr=num;
                int c=1;
                while(set.contains(c+num)){
                    c++;
                    // curr++;
                }
                len=Math.max(len,c);
            }
            
            // set.add(nums[i]);
        }
        return len;
    }
        
}

// class Solution {
//     public int longestConsecutive(int[] nums) {
//         Set<Integer> numSet = new HashSet<>();

//         for (int num : nums) {
//             numSet.add(num);
//         }

//         int longest = 0;

//         for (int n : numSet) {
//             if (!numSet.contains(n - 1)) {
//                 int length = 1;

//                 while (numSet.contains(n + length)) {
//                     length++;
//                 }

//                 longest = Math.max(longest, length);
//             }
//         }

//         return longest;
//     }
// }
