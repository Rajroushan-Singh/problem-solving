class Solution {
    public int totalFruit(int[] fruits) {
        int start=0;
        Map<Integer,Integer> map=new HashMap<>();
        int ans=0;
        for(int end=0;end<fruits.length;end++){
            map.put(fruits[end],map.getOrDefault(fruits[end],0)+1);
            while(map.size()>2){
                map.put(fruits[start],map.get(fruits[start])-1);
                if(map.getOrDefault(fruits[start],0)==0){
                    map.remove(fruits[start]);
                }
                // map.remove(fruits[start]);
                start++;
            }
            int s=0;
            for(int v:map.values()){
                s+=v;
            }
            ans=Math.max(ans,s);
        }
        return ans;
    }
}