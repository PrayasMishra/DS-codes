package doubleLinklist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DoubleLinkList {
	class Node{
		int data;
		Node next,prev;
		 Node(int val) { this.data = val; }
	}

	Node start;

	void delNode(Node n) {
		/* delete by node:
		 	Time Complexity = O(1)
		 	Space Complexity = O(1)
		*/
		if(start == null||n == null)
			return;
		else if (start == n)
			start = start.next;
		else if (n.next != null)
			n.next.prev = n.prev;
		else if (n.prev != null)
			n.prev.next = n.next;

		return;
	}

	void insertFront(int item) {
		Node tmp = new Node(item);
		if (start == null) {//empty list
			start.next = null;
			start.prev = null;
		} else{
			tmp.next = start;
			tmp.prev = null;
			start.prev = tmp;
		}
		//move the start to point to the new node i.e. tmp
		start = tmp;
	}

	void append(int item){
		Node tmp = new Node(item);
		if (start == null) {//empty list
			start = tmp;
			start.next = null;
			start.prev = null;
		}else {
			Node curr = start;

			while (curr.next != null)//traverse till the last node
				curr = curr.next;

			curr.next = tmp;
			tmp.prev = curr;
			tmp.next = null;
		}
	}

	void insertAfter(Node prevNode, int item){
		if (prevNode == null) {
			System.out.println("error in insertion: prevNode cannot be null...");
			return;
		}else {
			Node tmp = new Node(item);
			tmp.next = prevNode.next;
			tmp.prev = prevNode;
			prevNode.next = tmp;

			if (tmp.next != null)
				tmp.next.prev = tmp;
		}
	}

	void printList(){
		Node n = start;
		Node last = null;
		System.out.println("Traversal in forward Direction");
		while (n != null){
			System.out.print(n.data+" ");
			last = n;
			n = n.next;
		}
		System.out.println();

		n = last;
		System.out.println("Traversal in reverse Direction");
		while(n != null) {
			System.out.print(n.data+" ");
			n = n.prev;
		}
		System.out.println();
	}

	public static void main(String[] args)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		DoubleLinkList dll = new DoubleLinkList();

		System.out.println("enter length: ");
		int len = Integer.parseInt(reader.readLine());
		for (int i = 0; i < len; i++) {
			dll.append(Integer.parseInt(reader.readLine()));
		}

		dll.printList();
		dll.delNode(dll.start);
		dll.printList();

		reader.close();
	}
}
