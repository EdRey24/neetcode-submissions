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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode curr = sum;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int x;
            int y;
            if(l1 != null){
                x = l1.val;
            }else{
                x = 0;
            }
            if(l2 != null){
                y = l2.val;
            }else{
                y = 0;
            }
            int s = x + y + carry;
            carry = s / 10;
            ListNode num = new ListNode(s % 10);
            curr.next = num;
            curr = num;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return sum.next;
    }
}