package com.leetcode;

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
class MergueTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //Will merge l2 into l1

        ListNode newList = new ListNode(0);
        ListNode head = newList;

        while(l1 != null || l2 != null) {

            if (l1 == null) {
                newList.next = l2;
                return head.next;
            }

            if (l2 == null) {
                newList.next = l1;
                return head.next;
            }

            if (l1.val < l2.val) {
                newList.next = l1;
                l1 = l1.next;
                newList.next.next = null;
                newList = newList.next;

            } else if (l1.val > l2.val) {
                newList.next = l2;
                l2 = l2.next;
                newList.next.next = null;
                newList = newList.next;

            } else {
                newList.next = l1;
                l1 = l1.next;
                newList.next.next = null;
                newList = newList.next;

                newList.next = l2;
                l2 = l2.next;
                newList.next.next = null;
                newList = newList.next;

            }

        }

        return head.next;
    }

    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(4);

        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);

        ListNode newNode = mergeTwoLists(a,b);

        System.out.println(newNode.val);


    }
}

