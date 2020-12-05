package queues;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Queue{
	int[] arr;
	int front,rear,len,cap;

	Queue(int cap){
		this.cap = cap;
		this.front = this.len = 0;
		this.rear = this.cap -1;
		arr = new int[this.cap];
	}

	boolean isEmpty(Queue q){ return(q.len == 0); }
	boolean isFull(Queue q){ return (q.len == q.cap); }

	void enQueue(int x){
		if (isFull(this))
			System.out.println("Queue Overflow");
		else {
			this.rear = (this.rear+1)%this.cap;
			this.arr[this.rear] = x;
			this.len++;
			System.out.println(x+" enqued");
		}
	}

	int deQueue(){
		if (isEmpty(this)) {
			System.out.println("Queue Underflow");
			return Integer.MIN_VALUE;
		}
		else {
			int x = this.arr[this.front];
			this.front = (this.front+1)%this.cap;
			this.len--;
			System.out.println(x+" dequeued");
			return x;
		}
	}

	int peekFront(){
		if (isEmpty(this))
			return Integer.MIN_VALUE;

		return this.arr[this.front];
	}

	int peekRear(){
		if (isFull(this))
			return Integer.MIN_VALUE;

		return this.arr[this.rear];
	}

}

public class ArrayQueue {
	public static void main(String[] args)throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Queue q = new Queue( Integer.valueOf(reader.readLine()) );

		for (int i = 0; i < 5; i++) {
			q.enQueue( Integer.valueOf(reader.readLine()) );
		}
		q.deQueue();
		System.out.println("Front item is "+ q.peekFront());
		System.out.println("Rear item is "+ q.peekRear());

		reader.close();
	}
}
