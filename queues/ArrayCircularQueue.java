package queues;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ArrayCircularQueue {
	int front,rear,len;
	ArrayList<Integer> cirQueue = new ArrayList<Integer>();

	ArrayCircularQueue(int l){
		this.len = l;
		this.front = this.rear = -1;
	}

	int getFront(){return cirQueue.get(front);}
	int getRear(){return cirQueue.get(rear);}
	int getSize(){return len;}

	boolean checkFull(){ return ( (this.rear == getSize()-1 && this.front == 0) || this.rear == this.front-1 ); }
	boolean checkEmpty() { return ( this.front == -1 ); }

	void enCirQueue(int item){
		if (checkFull()) {
			System.out.println("CircularQueue is full!");
			return;
		} else if (checkEmpty())
		{
			front = 0;
			rear = 0;
			cirQueue.add(rear,item);
		}
		else if (this.rear == getSize()-1 && this.front != 0)
		{
			//updating old front value
			rear = 0;
			cirQueue.set(rear,item);
		}
		else
		{
			rear++;
			if (front <= rear)
				cirQueue.add(rear, item);	// Adding a new element
			else
				cirQueue.set(rear, item);	// updating old front value
		}

		System.out.println(item+" enqueued");
	}

	int deCirQueue(){
		if (checkEmpty()) {
			System.out.println("CircularQueue is empty!");
			return getFront();
		}

		int tmp = getFront();// de-queued item
		if (front == rear){//single element in queue
			front = -1;
			rear = -1;
		}else if (front == getSize()-1)
			front = 0;
		else
			front++;

		return tmp;
	}

	void display(){
		int i;
		if (checkEmpty())
			System.out.println("can't display, queue empty!");

		System.out.print("Elements in the circular queue are: ");
		if (rear >= front){
			for (i = front; i <= rear; i++) {
				System.out.print(cirQueue.get(i)+" ");
			}
		}
		else{
			for(i = front; i < getSize(); i++){
				System.out.print(cirQueue.get(i)+" ");
			}

			for(i = 0; i <= rear; i++) {
				System.out.print(cirQueue.get(i)+" ");
			}

		}
		System.out.println();
	}


	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter length: ");
		ArrayCircularQueue acq = new ArrayCircularQueue(Integer.parseInt(reader.readLine()));
		for (int k = 0; k < 5; k++) {
			acq.enCirQueue(Integer.parseInt(reader.readLine()));
		}
		System.out.println("de-queued item: "+ acq.deCirQueue());
		acq.display();

		reader.close();
	}
}
