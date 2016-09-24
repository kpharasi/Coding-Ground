package leetcodeLocked;

public class PlusOneLinkedList {
	
	private Node head;
	private int size;
	
	private class Node {
		Node next;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public PlusOneLinkedList() {
		head = null;
		size = 0;
	}
	
	public void insert(int data) {
		
		if(head==null) {
			head = new Node(data);
		}
		
		Node temp = new Node(data);
		Node curr = head;
		
		if(curr!=null) {
			while(curr.next!=null) {
				curr = curr.next;
			}
			//System.out.println(temp.data);
			curr.next = temp;
		}
		
		size++;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		Node curr = head.next;
		while(curr!=null) {
			sb.append("[" + curr.data + "]");
			curr = curr.next;
		}
		
		return sb.toString();
	}
	
	public Node plusOne() {
		Node temp = new Node(0);
		temp.next = head.next;
		Node one = temp;
		Node two = temp;
		
		while(one.next!=null) {
			one = one.next;
			
			if(one.data!=9) {
				two = one;
			}
		}
		
		if(one.data!=9) {
			one.data++;
		} else {
			two.data++;
			two = two.next;
			
			while(two!=null) {
				two.data = 0;
				two = two.next;
			}
		}
		
		if(temp.data==0) {
			return temp.next;
		}
		
		return temp;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PlusOneLinkedList l = new PlusOneLinkedList();
		
		l.insert(1);
		l.insert(9);
		l.insert(9);
		
		Node res = l.plusOne();
		
		while(res!=null) {
			System.out.println(res.data);
			res = res.next;
		}
	}

}
