package com.hectorflores;

import java.util.Scanner;
import java.util.Stack;





public class ReverseList {
	
	
	static class ListNode {
		int val;
	  ListNode next;
	  ListNode(int x) { val = x; }
	}
	public static ListNode function(ListNode node) {
		
	if (node == null) {												                                            
			return null;
		}
		
		Stack<ListNode> stack = new Stack<>();
		
		while(node != null) {
			stack.push(node);
			node = node.next;
		}
		ListNode aux = stack.pop();
		
		node = aux;
		while(!stack.isEmpty()) {
			aux.next = stack.pop();
			aux = aux.next;
		}
		aux.next = null;
		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		sc.nextLine();
		ListNode node=new ListNode(sc.nextInt()),aux=null;
		aux = node;
		
		while(count>0) {
			node.next = new ListNode(sc.nextInt());
			sc.nextLine();
			node = node.next;
			count--;
		}
		ReverseList.function(aux);
	}

}
