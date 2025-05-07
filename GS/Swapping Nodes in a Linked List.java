
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode firstK = head;

        for(int i=1;i<k;i++){
            firstK = firstK.next;
        }

        ListNode secondK = head;
        ListNode fast = firstK;

        while(fast.next!=null){
            fast=fast.next;
            secondK = secondK.next;
        }

        int val = firstK.val;
        firstK.val = secondK.val;
        secondK.val =val;

        return head;

    }
}