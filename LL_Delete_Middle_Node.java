// Question 2.3 - Cracking the Coding Interview 

import java.util.*;
import java.lang.*;
import java.io.*;


class LL_Delete_Middle_Node
{	
	public static LinkedList list;
	
	public static class LinkedList {
	private Node head;
	private int count = 0;
	
	public int getCount() {
		return count;
	}
	
	public Node getHead() {
		return head;
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
	
	public boolean remove(Node node) {
		
		if(node==null || node.next==null) {
			return false;
		}
		
		Node temp = node.next;
		node.data = temp.data;
		node.next = temp.next;
		
		return true;
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
		
		public Node getNext() {
			return next;
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		list = new LinkedList();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		System.out.println(list);
		
		list.remove(list.getHead().getNext().getNext());
		
		System.out.println("After Deleting the node at 2");
		System.out.println(list);
		
	}
}
}