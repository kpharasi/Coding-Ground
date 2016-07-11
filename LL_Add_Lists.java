// Question 2.5 - Cracking the Coding Interview 

import java.util.*;
import java.lang.*;
import java.io.*;


class LL_Add_Lists
{	
	public static LinkedList list1,list2;
	
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
	
	public static void add(LinkedList l1, LinkedList l2) {
		
		Node head1 = l1.getHead().next;
		Node head2 = l2.getHead().next;
		Node res = new LinkedList().new Node(-1);
		Node fakeResHead = res;
		int c = 0;
		
		while(head1!=null || head2!=null) {
			int temp = 0;
			
			if(head1==null) {
				temp = head2.data + c;
				head2 = head2.next;
			}
			
			else if(head2==null) {
				temp = head1.data + c;
				head1 = head1.next;
			}
			
			else {
				temp = head1.data + head2.data + c;
				head1 = head1.next;
				head2 = head2.next;
			}
			
			if((temp-10)<0) {
				res.next = new LinkedList().new Node(temp);
				res = res.next;
				c = 0;
			} else {
				res.next = new LinkedList().new Node(temp%10);
				res = res.next;
				c = 1;
			}
			
		}
		
		String sum = "";
		while(fakeResHead.next!=null) {
			sum = Integer.toString(fakeResHead.next.data) + sum;
			fakeResHead = fakeResHead.next;
		}
		
		System.out.println("The sum is: " + sum);
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
		list1 = new LinkedList();
		list2 = new LinkedList();
		
		list1.add(7);
		list1.add(1);
		list1.add(6);
		
		list2.add(5);
		list2.add(9);
		//list2.add(2);
		
		add(list1,list2);
		
	}
}
}