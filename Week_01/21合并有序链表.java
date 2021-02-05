/**
 * Definition for singly-linked list.
 * public class Solution02.ListNode {
 *     int val;
 *     Solution02.ListNode next;
 *     Solution02.ListNode() {}
 *     Solution02.ListNode(int val) { this.val = val; }
 *     Solution02.ListNode(int val, Solution02.ListNode next) { this.val = val; this.next = next; }
 * }
 */
//解题思路：递归
class Solution02 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }
}