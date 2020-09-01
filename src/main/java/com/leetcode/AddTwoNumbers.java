package com.leetcode;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		boolean carrier = false, flagl1 = false, flagl2 = false;
		ListNode result = new ListNode(0), head = null;
		ListNode myNode = null;
		int temp = 0;

		head = result;

		while ((l1 != null || l2 != null)) {

			if (carrier && (l1 == null)) {
				temp = l2.val + 1;
				carrier = false;
			} else if (carrier && (l2 == null)) {
				temp = l1.val + 1;
				carrier = false;
			} else if (carrier) {
				temp = l1.val + l2.val + 1;
				carrier = false;
			} else {
				if (l1 == null) {
					temp = l2.val;
				}else if (l2 == null) {
					temp = l1.val;
				}else {
					temp = l1.val + l2.val;
				}
				
			}

			if ((temp / 10) >= 1) {
				carrier = true;
				result.val = temp % 10;
			}else {
				result.val = temp;
			}
			

			
			myNode = result;
			result.next = new ListNode(0);
			result = result.next;

			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}

		}
		if (carrier == true) {
			result.val = 1;
		}else {
			myNode.next = null;
		}
		

		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(1);
		 //l2.next = new ListNode(6);
		// l2.next.next = new ListNode(4);

		AddTwoNumbers.addTwoNumbers(l1, l2);

	}

}
