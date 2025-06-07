LC---[206]
 Reverse Linked List
Given the head of a singly linked list, reverse the list, and return the reversed list.
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
    public ListNode reverseList(ListNode head) {
        ListNode curr=head;
        Stack<ListNode> stack=new Stack<ListNode>();

        while(curr!=null)
        {
            stack.push(curr);
            curr=curr.next;
        }

        ListNode res=new ListNode(-1);
        curr=res;

        while(!stack.isEmpty())
        {
            curr.next=stack.pop();
            curr=curr.next;
        }

        curr.next=null;

        return res.next;

    }
}
TC:O(N)
SC:O(N)
