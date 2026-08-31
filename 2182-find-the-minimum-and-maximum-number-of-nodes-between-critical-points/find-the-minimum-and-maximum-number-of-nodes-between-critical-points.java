/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode temp=head.next;
        ListNode prev=head;
        int i=1;
        int last=-1;
        int f=-1;
        int min=Integer.MAX_VALUE;
        while(temp.next!=null){
            i++;
            ListNode n=temp.next;
            //max
            if((temp.val > prev.val && temp.val >n.val) || (temp.val<prev.val && temp.val <n.val)){
                if(f==-1){
                    f=i;
                }else{
                    min=Math.min(min, i-last);
                }
                last=i;
            }

            
            temp=temp.next;
            prev=prev.next;
            // k++;
        }
        if(f==-1 || f==last){
            return new int[]{-1,-1};
        }
        int max=last-f;
        // if(list.size()<2)return new int[]{-1,-1};
        return new int[]{min,max};
    }
}