// Question 2.4 - Cracking the Coding Interview 

import java.util.*;
import java.lang.*;
import java.io.*;


class LL_Partition_List
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
	
	public void partition(int x) {
		
		if(head==null)
			return;
			
		Node curr = head.next;
		Node first = new Node(-1);
		Node firstFakeHead = first;
		Node second = new Node(-1);
		Node secondFakeHead = second;
		
		while(curr!=null) {
			if(curr.data>=x) {
				second.next = new Node(curr.data);
				second = second.next;
			} else {
				first.next = new Node(curr.data);
				first = first.next;
			}
			curr = curr.next;
		}
		
		first.next = secondFakeHead.next;
		
		System.out.println("After Partitioning around " + x);
		
		while(firstFakeHead.next!=null) {
			System.out.println(firstFakeHead.next.data);
			firstFakeHead = firstFakeHead.next;
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
		
		list.add(8);
		list.add(2);
		list.add(1);
		list.add(9);
		list.add(3);

		System.out.println("List Before Partitioning " + list);
		
		int x = 3;
		
		list.partition(x);
		
	}
}
}
