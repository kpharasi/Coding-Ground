// Question 2.5 (Follow Up) - Cracking the Coding Interview 

import java.util.*;
import java.lang.*;
import java.io.*;


class LL_Add_Lists_2
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
	
	public static int length(Node head) {
		
		Node curr = head;
		int len = 0;
		
		while(curr.next!=null) {
			len++;
			curr = curr.next;
		}
		
		return len;
	} 
	
	public static Node zeroPadding(Node l, int len) {
		
		Node curr = l;
		
		for(int i=0;i<len;i++) {
			curr = insertBefore(curr, 0);
		}
		
		return curr;
	}
	
	public static Node insertBefore(Node curr, int val) {
		
		Node pad = new LinkedList().new Node(val);
		
		if(curr!=null) {
			pad.next = curr;
		}
		
		return pad;
	}
	
	public static PartialSum addHelper(Node l1, Node l2) {
		
		if(l1==null && l2==null) {
			PartialSum sum = new LinkedList().new PartialSum();
			return sum;
		}
		
		PartialSum sum = addHelper(l1.next,l2.next);
		
		int val = sum.carry + l1.data + l2.data;
		
		Node full_result = insertBefore(sum.sum, val%10);
		
		sum.sum = full_result;
		sum.carry = val/10;
		return sum;
		
	}
	
	public static void add(Node l1, Node l2) {
		
		int len1 = length(l1);
		int len2 = length(l2);
		
		if(len1<len2) {
			l1 = zeroPadding(l1, len2-len1);
		} else {
			l2 = zeroPadding(l2, len1-len2);
		}
		
		PartialSum sum = addHelper(l1,l2);
		Node res = null;
		
		if(sum.carry == 0) {
			res = sum.sum;
		} else {
			res = insertBefore(sum.sum, sum.carry);
		}
		
		String final_sum = "";
		while(res!=null) {
			final_sum = final_sum + Integer.toString(res.data);
			res = res.next;
		}
		
		System.out.println("The sum is: " + final_sum);
		
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
	
	class PartialSum {
		
		public Node sum = null;
		public int carry = 0;
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
		
		add(list1.getHead().next,list2.getHead().next);
		
	}
}
}
