class SnapshotArray {
    // int[] arr;
    List<List<int[]>> list=new ArrayList<>();
    int snap_id=0;
    public SnapshotArray(int length) {
        // arr=new int[length];
        for(int i=0;i<length;i++){
            list.add(new ArrayList<>());
            list.get(i).add(new int[]{0,0});
        }
        // Arrays.fill(arr,0);
    }
    
    public void set(int index, int val) {
        List<int[]> l=list.get(index);
        if(l.get(l.size()-1)[0]==snap_id){
            l.get(l.size()-1)[1]=val;
        }else{
            l.add(new int[]{snap_id,val});
        }   
    }
    
    public int snap() {
        return snap_id++;
    }
    
    public int get(int index, int snap_id) {
        List<int[]> l=list.get(index);
        int low=0;
        int high=l.size()-1;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(l.get(mid)[0]<=snap_id){
                ans=l.get(mid)[1];
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */