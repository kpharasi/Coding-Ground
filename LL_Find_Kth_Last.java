// Question 2.2 - Cracking the Coding Interview 

import java.util.*;
import java.lang.*;
import java.io.*;


class LL_Find_Kth_Last
{	
	public static LinkedList list;
	
	public static class LinkedList {
	private Node head;
	private int count = 0;
	
	public int getCount() {
		return count;
	}
	
	public void add(int data) {
		
		if(head==null) {
			head = new Node(data);
		}
		
		Node temp = new Node(data);
		Node curr = head;
		
		if(curr!=null) {
			
			while(curr.next!=null) {
				curr = curr.next;
			}
			
			curr.next = temp;
		}
		count++;
	}
	
	// Approach 1
	
	public void find_app1(int index, int len) {
		
		if(index<1 || index>=len) {
			System.out.println("Index not in range");
			return;
		}
		
		Node curr = head;
		
		if(curr!=null) {
			
			for(int i=0;i<=index;i++) {
				curr = curr.next;
			}
			
			System.out.println("Element at index " + (len-index) + " from last is " + curr.data);
		}
		
	}
	
	// Approach 2
	
	public int find_app2(int index) {
		return find_app2_helper(head, index);
	}
	
	public int find_app2_helper(Node head, int index) {
		
		if(head==null)
			return 0;
			
		int curr_index = find_app2_helper(head.next, index) + 1;
		
		if(curr_index==index) {
			System.out.println("Element at index " + index + " from last is " + head.data);
		}
		
		return curr_index;
	}
	
	// Approach 3
	
	public void find_app3(int index) {
		find_app3_helper(head, index);
	}
	
	public void find_app3_helper(Node head, int index) {
		
		Node slow = head;
		Node fast = head;
		
		for(int i=0; i<index;i++) {
			if(fast==null) {
				System.out.println("Check value of index");
				return;
			}
			fast = fast.next;
		}
		
		while(fast!=null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		System.out.println("Element at index " + index + " from last is " + slow.data);
	}
	
	public String toString() {
		
		String res = "";
		boolean flag = false;
		
		if(head != null) {
			Node curr = head.next;
			
			while(curr!=null) {
				
				if(!flag) {
					res += curr.data;
					flag = true;
				} else {
					res += "," + curr.data;
				}
				curr = curr.next;
			}
		}
		
		return res;
	}
	
	
	private class Node {
		
		int data;
		Node next;
		
		public Node(int d) {
			data = d;
			next = null;
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		list = new LinkedList();
		
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(2);
		list.add(3);
		
		int index = 1;
		
		// Approach 1: 
		// If an input of 2 is given by the user (2nd last element will be at the third index)
		// Therefore actual index will be length of list - the input provided
		int len = list.getCount();
		int last_index = len - index;
		//list.find_app1(last_index, len);
		
		//Approach 2: 
		//list.find_app2(index);
		
		//Approach 3:
		list.find_app3(index);
		
		//System.out.println(list);
	}
}
}