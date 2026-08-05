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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int length = 0;
        while(curr != null){
            curr = curr.next;
            length++;
        }
        int removeIdx = length - n;
        ListNode prev = null;
        curr = head;
        int i = 0;
        while(i < removeIdx){
            prev = curr;
            curr = curr.next;
            i++;
        }
        if(prev == null){
            return curr.next;
        }
        prev.next = curr.next;
        return head;

    }
}
