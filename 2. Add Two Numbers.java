/*
2. Add Two Numbers
Medium

6426

1681

Favorite

Share
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;
        int sum = 0;
        while(l1!= null && l2 != null) 
        {
            sum += l1.val + l2.val;
            curr.val = sum%10;
            sum/=10;
            
            // System.out.println(l1.val + "\t" +l2.val);
            l1 = l1.next;
            l2 = l2.next;
            
            if(l1!= null || l2 != null)
            {
                curr.next = new ListNode(0);
                curr = curr.next;
            }
        }
        while(l1!=null)
        {
            sum += l1.val;
            curr.val = sum%10;
            sum/=10;
            l1 = l1.next;
            if(l1!=null)
            {
                curr.next = new ListNode(0);
                curr = curr.next;
            }
            // System.out.println("Enter 1");
        }

        while(l2!=null)
        {
            sum += l2.val;
            curr.val = sum%10;
            sum/=10;
            l2 = l2.next;
            if(l2!=null)
            {
                curr.next = new ListNode(0);
                curr = curr.next;
            }
            // System.out.println("Enter 2");

        }
        // System.out.println(sum);

        if(sum!=0)
            curr.next = new ListNode(1);
        return res;
    }
}