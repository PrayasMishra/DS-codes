package queues;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class LinkListQueue {
	class Node{
		int data;
		Node next;
		Node(int val){
			this.data = val;
			this.next = null;
		}
	}
	Node front,rear;

	LinkListQueue(){
		this.front = this.rear = null;
	}

	boolean checkEmpty(LinkListQueue llq){ return (front == null||rear == null); }

	void enQueue(int item){
		Node tmp = new Node(item);

		if (checkEmpty(this)){
			this.front = this.rear = tmp;
		}else {
			this.rear.next = tmp;
			this.rear = tmp;
		}
		System.out.println(tmp.data+" enqueued");
	}

	void deQueue(){
		if (checkEmpty(this))
			System.out.println("queue was empty");
		else{
			Node tmp = this.front;
			this.front = this.front.next;
			System.out.println(tmp.data+" dequeued");
		}
	}

	int showFront(){
		if (checkEmpty(this))
			return Integer.MIN_VALUE;

		return this.front.data;
	}

	int showRear(){
		if (checkEmpty(this))
			return Integer.MIN_VALUE;

		return this.rear.data;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		LinkListQueue llq1 = new LinkListQueue();
		for (int i = 0; i < 5; i++) {
			llq1.enQueue( Integer.valueOf(reader.readLine()) );
		}
		llq1.deQueue();
		System.out.println("front-> "+llq1.showFront());
		System.out.println("rear-> "+llq1.showRear());
	}
}
