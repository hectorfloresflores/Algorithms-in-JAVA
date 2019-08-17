package com.hectorflores;

import java.util.ArrayList;

import java.util.List;

import com.hectorflores.ReverseList.ListNode;




public class InsertionSortList {

	
	
	public static ListNode insertionSortList(ListNode head) {

		if (head == null) {
			return head;
		}
		List<Integer> myList = fillList(head);
		ListNode node = head;
		
		int positionBefore = 0;
		int positionNext = 1;
		int auxVal = 0;
		while(positionNext < myList.size()) {
			
			
			while(positionBefore >= 0) {
				
				auxVal = myList.get(positionBefore+1);
				
				if (myList.get(positionBefore) > auxVal) {
					myList.set(positionBefore+1, myList.get(positionBefore));
					myList.set(positionBefore, auxVal);
					positionBefore--;
				}else {
					break;
				}
				
			}
			positionBefore = positionNext;
			positionNext++;
			
		}
		
		auxVal = 0;
		while(head != null) {
			head.val = myList.get(auxVal);
			head = head.next;
			auxVal++;
		}
		
		return node;
		
	}

	private static ArrayList<Integer> fillList(ListNode head) {
		
		List<Integer> myList = new ArrayList<>();
		
		while(head != null) {
			myList.add(head.val);
			head = head.next;
		}
		
		return (ArrayList<Integer>) myList;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(4);
		node.next = new ListNode(2);
		node.next.next = new ListNode(1);
		node.next.next.next = new ListNode(3);
//		node.next.next.next.next = new ListNode(7);
		insertionSortList(node);
		int j = 0;
	}

}
