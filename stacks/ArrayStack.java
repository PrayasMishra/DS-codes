package stacks;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Stack{
	static final int MAX = 100;
	int top;
	int[] arr = new int[MAX];

	Stack(){
		top = -1;
	}

	void printWholeStack(){
		if(top < 0)
			System.out.println("Stack Underflow, Push elements to Peek.");
		else{
			for (int i = top; i >=0 ; i--) {
				System.out.println(arr[i]);
			}
		}
	}

	int peek(){
		if(top < 0){
			System.out.println("Stack Underflow, Push elements to Peek.");
			return -1;
		}else {
			return arr[top];
		}
	}

	boolean push(int val){
		if(top >= MAX-1){
			System.out.println("Stack Overflow");
			return false;
		}
		else{
			top++;
			arr[top] = val;
			System.out.println(val+" pushed to stack");
			return true;
		}
	}

	int pop(){
		if (top < 0){
			System.out.println("Stack Underflow");
			return -1;
		}
		else {
			int x = arr[top];
			top--;
			return x;
		}
	}

	boolean isStackEmpty(){
		return (top < 0 ? true: false);
	}
}

public class ArrayStack {
	public static void main(String[] args) throws IOException{
		BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
		Stack s =new Stack();
		for (int i = 0; i < 5; i++) {
			s.push(Integer.valueOf(reader.readLine()));
		}

		System.out.println("Stack->from top");
		s.printWholeStack();
		System.out.print("popped->\n"+s.pop());

		reader.close();
	}
}
