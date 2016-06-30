// Question 2.1 - Cracking the Coding Interview 

import java.util.*;
import java.lang.*;
import java.io.*;


class Linked_List_Duplicate
{	
	public static LinkedList list;
	
	public static class LinkedList {
	private Node head;
	
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
	
	public void remove_duplicate() {
		Set<Integer> set = new HashSet<Integer>();
		
		Node temp = head.next;
		Node curr = null;
		
		int i =0;
		
		while(temp!=null) {
			if(set.contains(temp.data)) {
				curr.next = temp.next;
			} else {
					set.add(temp.data);
					curr = temp;
			}
				
			temp = temp.next;
		}
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
		
		list.remove_duplicate();
		
		System.out.println(list);
	}
}
}