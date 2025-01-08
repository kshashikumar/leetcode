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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 =list2;
        ListNode temp;
        if(temp1 == null && temp2 == null){
            return temp1;
        } else if(temp1 == null){
            return temp2;
        } else if(temp2 == null){
            return temp1;
        }

        while(temp1 != null && temp2 != null){
            
            if(temp1.val <= temp2.val){
                System.out.println(temp1.val);
                if(temp1.next != null && temp1.next.val <= temp2.val){
                    temp1=temp1.next;
                } else {
                temp = temp1.next;
                temp1.next = temp2;
                temp1 = temp;
                }
            } else if(temp1.val > temp2.val) {
                if(temp2.next != null && temp2.next.val < temp1.val){
                    temp2=temp2.next;
                } else {
                temp = temp2.next;
                temp2.next = temp1;
                temp2 = temp;
                }
            }
        }
    return list1.val > list2.val ? list2: list1;
    }
}