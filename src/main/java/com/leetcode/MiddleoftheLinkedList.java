package com.leetcode;

//Given a non-empty, singly linked list with head node head, return a middle node of linked list.
//
//        If there are two middle nodes, return the second middle node.
//
//
//
//        Example 1:
//
//        Input: [1,2,3,4,5]
//        Output: Node 3 from this list (Serialization: [3,4,5])
//        The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
//        Note that we returned a ListNode object ans, such that:
//        ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
//        Example 2:
//
//        Input: [1,2,3,4,5,6]
//        Output: Node 4 from this list (Serialization: [4,5,6])
//        Since the list has two middle nodes with values 3 and 4, we return the second one.
//
//
//        Note:
//
//        The number of nodes in the given list will be between 1 and 100.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1(int x) { val = x; }
}
public class MiddleoftheLinkedList {



    public static ListNode1 middleNode(ListNode1 head) {
        ListNode1 aux = head;
        double counter = 0;
        while (aux != null) {
            counter++;
            aux = aux.next;
        }
        if (counter % 2 != 0) {
            counter = Math.ceil(counter/2) - 1;
        } else {
            counter = Math.ceil(counter/2);
        }
        int i = 0;
        while (i < counter) {
            head = head.next;
            i++;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode1 node = new ListNode1(1);
        node.next = new ListNode1(2);
        node.next.next = new ListNode1(3);
        node.next.next.next = new ListNode1(4);
        System.out.println(MiddleoftheLinkedList.middleNode(node).val);
    }

}
