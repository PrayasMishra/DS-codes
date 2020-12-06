package queues;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkListCircularQueue {
	class Node{
		int data;
		Node next;

		Node(int val){
			this.data = val;
		}
	}

	Node front,rear;

	LinkListCircularQueue(){
		this.front = this.rear = null;
	}


	void enCirQueue(int item){
		Node tmp = new Node(item);
		if (front == null){
			front = tmp;
		}else {
			rear.next = tmp;
		}

		rear = tmp;
		rear.next = front;
	}

	int deCirQueue(){
		if (front == null){
			System.out.println("queue empty...");
			return Integer.MIN_VALUE;
		}else {
			Node tmp = front;
			front = front.next;
			rear.next = front;

			return tmp.data;
		}
	}

	void dispQueue(){
		Node temp = front;
		System.out.println("Elements in Circular Queue are: ");
		while (temp.next != front) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.print(temp.data+" ");
	}

	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		LinkListCircularQueue llcq = new LinkListCircularQueue();
		llcq.deCirQueue();
		for (int i = 0; i < 5; i++) {
			llcq.enCirQueue(Integer.parseInt(reader.readLine()));
		}

		System.out.println("de-queued item: "+llcq.deCirQueue());
		llcq.dispQueue();

		reader.close();
	}
}
