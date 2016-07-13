// Question 2.6 - Cracking the Coding Interview 

import java.util.*;
import java.lang.*;
import java.io.*;


class LL_Palindrome
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
	
		public boolean isPalindrome() {
			HeadAndTail rev = reverse(head.next);
			Node revHead = rev.head;
			return isEqual(head.next, revHead);
		}		
	
		public HeadAndTail reverse(Node curr) {
			if(curr==null)
				return null;
			
			HeadAndTail temp = reverse(curr.next);
			
			try {
			Node cloneHead = (Node)curr.clone();
			cloneHead.next = null;
			
			if(temp == null) {
				return new HeadAndTail(cloneHead, cloneHead);
			}
			temp.tail.next = cloneHead;
			
			return new HeadAndTail(temp.head, cloneHead);
			} catch (Exception e) {
				System.out.println("Error " + e);
			}
			
			return null;
		} 
		
		public static boolean isEqual(Node one, Node two) {
			Node head1 = one;
			Node head2 = two;
			
			while(head1!=null && head2!=null) {
				if(head1.data!=head2.data) {
					return false;
				}
				head1 = head1.next;
				head2 = head2.next;
			}
			
			if(head1==null && head2==null) {
				return true;
			} 
			return false;
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
	
		public class HeadAndTail {
			public Node head;
			public Node tail;
			public HeadAndTail(Node h, Node t) {
				head = h;
				tail = t;
			}
		}
		
		private class Node implements Cloneable{
		
			int data;
			Node next;
		
			public Node(int d) {
				data = d;
				next = null;
			}
		
			public Node getNext() {
				return next;
			}
			
			@Override
			public Node clone() throws CloneNotSupportedException {
    	 		return (Node)super.clone();
    		}
		}
		
		
		
	public static void main (String[] args) throws java.lang.Exception
	{
		list = new LinkedList();
		
		list.add(1);
		list.add(7);
		list.add(3);
		list.add(7);
		list.add(1);

		boolean flag = list.isPalindrome();
		
		if(flag == true) {
			System.out.println("It is a Palindrome");	
		} else {
			System.out.println("It is not a Palindrome");
		}
		
		
	}
}
}