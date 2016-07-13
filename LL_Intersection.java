// Question 2.6 - Cracking the Coding Interview 

import java.util.*;
import java.lang.*;
import java.io.*;


class LL_Intersection
{	
	public static LinkedList list1, list2;
	
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
		
		public void add(Node node) {
			
			if(head==null) {
				head = new Node(node.data);
			}
					
			Node curr = head;
	
			if(curr!=null) {
			
				while(curr.next!=null) {
					curr = curr.next;
				}
			
				curr.next = node;
			}
			count++;
		}
	
		public static Node intersection(LinkedList l1, LinkedList l2) {
			
			Node head1 = l1.getHead().next;
			Node head2 = l2.getHead().next;
			int len1 = l1.getCount();
			int len2 = l2.getCount();
			int diff = 0;
			
			
			if(len1>len2) {
				diff = len1 - len2;
				while(diff>0) {
					head1 = head1.next;
					diff--;
				}
			} else {
				diff = len2 - len1;
				while(diff>0) {
					head2 = head2.next;
					diff--;
				}
			}
			
			while(head1!=null && head2!=null) {
				if(head1==head2) {
					return head1;
				}
				
				head1 = head1.next;
				head2 = head2.next;
			}
			
			return null;
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
	
		
		public class Node {
		
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
		list1 = new LinkedList();
		list2 = new LinkedList();
		
		Node a = new LinkedList().new Node(1);
		
		Node b = new LinkedList().new Node(2);
		Node c = new LinkedList().new Node(3);
		Node d = new LinkedList().new Node(4);
		Node e = new LinkedList().new Node(5);
		Node f = new LinkedList().new Node(6);
		Node g = new LinkedList().new Node(7);
		Node h = new LinkedList().new Node(8);
		
		list1.add(a);
		list1.add(b);
		list1.add(c);
		list1.add(d);
		list2.add(e);
		list2.add(f);
		list2.add(g);
		list2.add(c);
		list2.add(h);
		
		Node res = intersection(list1,list2);
		
		System.out.println("Point of Intersection: " + res.data);
	}
}
}